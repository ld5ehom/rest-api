package com.ld5ehom.restapi;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

// RestDocs configuration for MockMvc tests.
// Configures request and response preprocessors to pretty-print payloads.
// MockMvc 테스트용 RestDocs 설정 클래스.
// 요청과 응답을 보기 좋게 출력하도록 Preprocessor를 설정한다.
@TestConfiguration
public class RestDocsConfig {

    // Customize RestDocsMockMvc configuration with pretty printing.
    // RestDocsMockMvc 설정을 요청/응답에 대해 pretty print 적용으로 커스터마이징.
    @Bean
    public RestDocsMockMvcConfigurationCustomizer restDocsMockMvcConfigurationCustomizer() {
        return configurer -> configurer.operationPreprocessors()
                .withRequestDefaults(prettyPrint())
                .withResponseDefaults(prettyPrint());
    }
}
