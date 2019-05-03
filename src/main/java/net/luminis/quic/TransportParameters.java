/*
 * Copyright © 2019 Peter Doornbosch
 *
 * This file is part of Kwik, a QUIC client Java library
 *
 * Kwik is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * Kwik is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.luminis.quic;

import java.net.InetAddress;

public class TransportParameters {

    private byte[] originalConnectionId;
    private long idleTimeoutInSeconds;
    private long initialMaxData;
    private long initialMaxStreamDataBidiLocal;
    private long initialMaxStreamDataBidiRemote;
    private long initialMaxStreamDataUni;
    private long initialMaxStreamsBidi;
    private long initialMaxStreamsUni;
    private int ackDelayExponent;
    private boolean disableMigration;
    private PreferredAddress preferredAddress;


    public TransportParameters() {
    }

    public TransportParameters(int idleTimeoutInSeconds, int initialMaxStreamData, int initialMaxStreamsBidirectional, int initialMaxStreamsUnidirectional) {
        this.idleTimeoutInSeconds = idleTimeoutInSeconds;
        initialMaxData = 10 * initialMaxStreamData;
        // All stream data values are equal. When changing this, also change the getter in QuicConnection, used by the streams.
        initialMaxStreamDataBidiLocal = initialMaxStreamData;
        initialMaxStreamDataBidiRemote = initialMaxStreamData;
        initialMaxStreamDataUni = initialMaxStreamData;
        this.initialMaxStreamsBidi = initialMaxStreamsBidirectional;
        this.initialMaxStreamsUni = initialMaxStreamsUnidirectional;
        ackDelayExponent = 0;
    }

    public byte[] getOriginalConnectionId() {
        return originalConnectionId;
    }

    public void setOriginalConnectionId(byte[] originalConnectionId) {
        this.originalConnectionId = originalConnectionId;
    }

    public void setAckDelayExponent(int ackDelayExponent) {
        this.ackDelayExponent = ackDelayExponent;
    }

    public int getAckDelayExponent() {
        return ackDelayExponent;
    }

    public PreferredAddress getPreferredAddress() {
        return preferredAddress;
    }

    public void setPreferredAddress(PreferredAddress preferredAddress) {
        this.preferredAddress = preferredAddress;
    }

    public long getIdleTimeout() {
        return idleTimeoutInSeconds;
    }

    public void setIdleTimeout(long idleTimeout) {
        this.idleTimeoutInSeconds = idleTimeout;
    }

    public long getInitialMaxData() {
        return initialMaxData;
    }

    public long getInitialMaxStreamDataBidiLocal() {
        return initialMaxStreamDataBidiLocal;
    }

    public long getInitialMaxStreamDataBidiRemote() {
        return initialMaxStreamDataBidiRemote;
    }

    public long getInitialMaxStreamDataUni() {
        return initialMaxStreamDataUni;
    }

    public long getInitialMaxStreamsBidi() {
        return initialMaxStreamsBidi;
    }

    public long getInitialMaxStreamsUni() {
        return initialMaxStreamsUni;
    }

    public static class PreferredAddress {
        InetAddress ip4;
        int ip4Port;
        InetAddress ip6;
        int ip6Port;
        byte[] connectionId;
        byte[] statelessResetToken;
    }
}
