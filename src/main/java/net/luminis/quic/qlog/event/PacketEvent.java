/*
 * Copyright © 2020, 2021, 2022 Peter Doornbosch
 *
 * This file is part of Kwik, an implementation of the QUIC protocol in Java.
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
package net.luminis.quic.qlog.event;

import net.luminis.quic.packet.QuicPacket;
import net.luminis.quic.qlog.QLogEvent;

import java.time.Instant;

public abstract class PacketEvent extends QLogEvent {

    private final QuicPacket packet;

    public PacketEvent(byte[] cid, QuicPacket packet, Instant time) {
        super(cid, time);
        this.packet = packet;
    }

    public QuicPacket getPacket() {
        return packet;
    }


}
