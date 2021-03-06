/*
 * SonarLint Core - Client API
 * Copyright (C) 2009-2020 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarsource.sonarlint.core.client.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.junit.Test;

public class TelemetryClientConfigTest {
  @Test
  public void testClientConfig() {
    Proxy proxy = new Proxy(Type.SOCKS, new InetSocketAddress(1234));
    TelemetryClientConfig config = new TelemetryClientConfig.Builder()
      .proxyPassword("password")
      .proxyLogin("proxyLogin")
      .userAgent("agent")
      .proxy(proxy)
      .build();

    assertThat(config.proxy()).isEqualTo(proxy);
    assertThat(config.proxyLogin()).isEqualTo("proxyLogin");
    assertThat(config.proxyPassword()).isEqualTo("password");
    assertThat(config.userAgent()).isEqualTo("agent");

  }
}
