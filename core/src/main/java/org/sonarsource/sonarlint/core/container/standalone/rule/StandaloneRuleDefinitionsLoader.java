/*
 * SonarLint Core - Implementation
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
package org.sonarsource.sonarlint.core.container.standalone.rule;

import org.sonar.api.server.rule.RulesDefinition;

/**
 * Load rules directly from plugins {@link RulesDefinition}
 */
public class StandaloneRuleDefinitionsLoader {
  private final RulesDefinition.Context context;

  public StandaloneRuleDefinitionsLoader() {
    // No plugin installed
    context = new RulesDefinition.Context();
  }

  public StandaloneRuleDefinitionsLoader(RulesDefinition[] pluginDefs) {

    context = new RulesDefinition.Context();
    for (RulesDefinition pluginDefinition : pluginDefs) {
      pluginDefinition.define(context);
    }
  }

  public RulesDefinition.Context getContext() {
    return context;
  }

}
