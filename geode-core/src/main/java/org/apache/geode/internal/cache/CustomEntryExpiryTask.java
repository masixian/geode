/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.geode.internal.cache;

import org.apache.geode.cache.ExpirationAttributes;

/**
 * Remembers the expiration attributes returned from the customer's CustomExpiry callback, if any.
 * 
 * @since GemFire 8.0
 *
 */
public class CustomEntryExpiryTask extends EntryExpiryTask {
  private final ExpirationAttributes ttlAttr;
  private final ExpirationAttributes idleAttr;

  public CustomEntryExpiryTask(LocalRegion region, RegionEntry re, ExpirationAttributes ttlAtts,
      ExpirationAttributes idleAtts) {
    super(region, re);
    this.ttlAttr = ttlAtts;
    this.idleAttr = idleAtts;
  }

  @Override
  protected ExpirationAttributes getTTLAttributes() {
    return this.ttlAttr;
  }

  @Override
  protected ExpirationAttributes getIdleAttributes() {
    return this.idleAttr;
  }

}
