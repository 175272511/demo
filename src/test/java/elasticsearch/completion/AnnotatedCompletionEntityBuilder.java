/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package elasticsearch.completion;

import org.springframework.data.elasticsearch.core.completion.Completion;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

/**
 * @author Franck Marchand
 * @author Mohsin Husen
 * @author Mewes Kochheim
 */
public class AnnotatedCompletionEntityBuilder {

	private AnnotatedCompletionEntity result;

	public AnnotatedCompletionEntityBuilder(String id) {
		result = new AnnotatedCompletionEntity(id);
	}

	public AnnotatedCompletionEntityBuilder name(String name) {
		result.setName(name);
		return this;
	}

	public AnnotatedCompletionEntityBuilder suggest(String[] input) {
		return suggest(input, null, null, null);
	}

	public AnnotatedCompletionEntityBuilder suggest(String[] input, String output) {
		return suggest(input, output, null, null);
	}

	public AnnotatedCompletionEntityBuilder suggest(String[] input, String output, Object payload) {
		return suggest(input, output, payload, null);
	}

	public AnnotatedCompletionEntityBuilder suggest(String[] input, String output, Object payload, Integer weight) {
		Completion suggest = new Completion(input);
		suggest.setOutput(output);
		suggest.setPayload(payload);
		suggest.setWeight(weight);

		result.setSuggest(suggest);
		return this;
	}

	public AnnotatedCompletionEntity build() {
		return result;
	}

	public IndexQuery buildIndex() {
		IndexQuery indexQuery = new IndexQuery();
		indexQuery.setId(result.getId());
		indexQuery.setObject(result);
		return indexQuery;
	}
}
