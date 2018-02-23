/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.servicebroker.model.instance;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.springframework.cloud.servicebroker.model.Context;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class GetLastServiceOperationRequestTest {
	@Test
	public void requestWithDefaultsIsBuilt() {
		GetLastServiceOperationRequest request = GetLastServiceOperationRequest.builder()
				.build();

		assertThat(request.getServiceDefinitionId(), nullValue());
		assertThat(request.getServiceInstanceId(), nullValue());
		assertThat(request.getPlanId(), nullValue());
		assertThat(request.getOperation(), nullValue());
		assertThat(request.getApiInfoLocation(), nullValue());
		assertThat(request.getPlatformInstanceId(), nullValue());
		assertThat(request.getOriginatingIdentity(), nullValue());
	}

	@Test
	@SuppressWarnings("serial")
	public void requestWithAllValuesIsBuilt() {
		Context originatingIdentity = Context.builder()
				.platform("test-platform")
				.build();

		GetLastServiceOperationRequest request = GetLastServiceOperationRequest.builder()
				.serviceInstanceId("service-instance-id")
				.serviceDefinitionId("service-definition-id")
				.planId("plan-id")
				.operation("working")
				.platformInstanceId("platform-instance-id")
				.apiInfoLocation("https://api.example.com")
				.originatingIdentity(originatingIdentity)
				.build();

		assertThat(request.getServiceInstanceId(), equalTo("service-instance-id"));
		assertThat(request.getServiceDefinitionId(), equalTo("service-definition-id"));
		assertThat(request.getPlanId(), equalTo("plan-id"));
		assertThat(request.getOperation(), equalTo("working"));

		assertThat(request.getPlatformInstanceId(), equalTo("platform-instance-id"));
		assertThat(request.getApiInfoLocation(), equalTo("https://api.example.com"));
		assertThat(request.getOriginatingIdentity(), equalTo(originatingIdentity));
	}

	@Test
	public void equalsAndHashCode() {
		EqualsVerifier
				.forClass(GetLastServiceOperationRequest.class)
				.withRedefinedSuperclass()
				.suppress(Warning.NONFINAL_FIELDS)
				.suppress(Warning.TRANSIENT_FIELDS)
				.verify();
	}
}