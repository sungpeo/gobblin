/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gobblin.compliance;

/**
 * Each Hive Dataset using gobblin-compliance for their compliance needs, must contain a dataset.descriptor property
 * in the tblproperties of a Hive Dataset.
 *
 * A dataset.descriptor is a description of a Hive dataset in the Json format.
 *
 * A compliance id is a column name in a Hive dataset to decide which records should be purged.
 *
 * A dataset.descriptor must contain an identifier whose value corresponds the column name containing compliance id.
 *
 * Path to the identifier must be specified in the job properties file
 * via property dataset.descriptor.identifier.
 *
 * Example : dataset.descriptor = {Database : Repos, Owner : GitHub, ComplianceInfo : {IdentifierType : GitHubId}}
 * If IdentifierType corresponds to the identifier and GithubId is the compliance id column name, then
 * dataset.descriptor.identifier = ComplianceInfo.IdentifierType
 *
 * @author adsharma
 */
public interface DatasetDescriptor {
  public String getComplianceId();
}
