package com.example.springstudy.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class MybatisTest {

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @TestConfiguration
    public static class TestContext {

        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .addDefaultScripts()
                    .build();
        }

        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws Exception {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
            sqlSessionFactoryBean.setMapperLocations(new ClassPathResource[]{new ClassPathResource("mapper/TestSqlMap.xml")});

            return sqlSessionFactoryBean;
        }
    }

    /**
     * returnInstanceForEmptyRow 설정이 false일때,
     * 모든 컬럼의 데이터가 null인 경우, List내의 항목이 null이 되는 경우 테스트
     * @throws Exception
     */
    @Test
    public void all_element_null_test_returnInstanceForEmptyRow_false() throws Exception {

        sqlSessionFactoryBean.getObject().getConfiguration().setReturnInstanceForEmptyRow(false);

        List<TestDTO> tests = sqlSessionFactoryBean.getObject()
                .openSession()
                .getMapper(TestRepository.class)
                .getTestAll();

        tests.removeIf(Objects::isNull);
        assertThat(tests).isEmpty();
    }

    /**
     * returnInstanceForEmptyRow 설정이 true일때,
     * 모든 컬럼의 데이터가 null인 경우, 모든 property가 null인 인스턴스가 생성되는지에 대한 테스트
     * @throws Exception
     */
    @Test
    public void all_element_null_test_returnInstanceForEmptyRow_true() throws Exception {

        sqlSessionFactoryBean.getObject().getConfiguration().setReturnInstanceForEmptyRow(true);

        List<TestDTO> tests = sqlSessionFactoryBean.getObject()
                .openSession()
                .getMapper(TestRepository.class)
                .getTestAll();

        tests.removeIf(Objects::isNull);
        assertThat(tests).isNotEmpty();
    }
}
