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
package org.sonarsource.sonarlint.core.container.storage;

import java.util.Collection;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.sonar.api.batch.rule.RuleParam;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rules.RuleType;
import org.sonarsource.sonarlint.core.container.analysis.SonarLintRule;

public class StorageRuleAdapter implements SonarLintRule {

  private org.sonarsource.sonarlint.core.proto.Sonarlint.Rules.Rule r;

  public StorageRuleAdapter(org.sonarsource.sonarlint.core.proto.Sonarlint.Rules.Rule r) {
    this.r = r;
  }

  @Override
  public RuleKey key() {
    return RuleKey.of(r.getRepo(), r.getKey());
  }

  @Override
  public String name() {
    return r.getName();
  }

  @Override
  public String description() {
    return r.getHtmlDesc();
  }

  @Override
  public String internalKey() {
    return r.getInternalKey();
  }

  @Override
  public String severity() {
    return r.getSeverity();
  }

  @Override
  public RuleType type() {
    return StringUtils.isNotBlank(r.getType()) ? RuleType.valueOf(r.getType().toUpperCase(Locale.ENGLISH)) : null;
  }

  @Override
  public RuleParam param(String paramKey) {
    throw new UnsupportedOperationException("param");
  }

  @Override
  public Collection<RuleParam> params() {
    throw new UnsupportedOperationException("param");
  }

  @Override
  public RuleStatus status() {
    throw new UnsupportedOperationException("status");
  }

}
