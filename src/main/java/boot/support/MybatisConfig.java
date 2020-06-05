package boot.support;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.math.BigDecimal;

/**
 * @author jinjunzhu
 * @date 2018/07/18
 */
@Scope
@Component("mybatisConfig")
@MapperScan(basePackages={"boot.repository.dao1"}, sqlSessionFactoryRef = "firstSqlSessionFactory")
public class MybatisConfig {

	@Bean(name="firstDataSource")
	@ConfigurationProperties(prefix="datasource.first")
	@Primary
	public DataSource firstDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "firstSqlSessionFactory")
	public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/mybatis-config.xml"));
		return bean.getObject();
	}

	@Bean(name = "firstTransactionManager")
	@Primary
	public DataSourceTransactionManager firstTransactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "firstSqlSessionTemplate")
	public SqlSessionTemplate firstSqlSessionTemplate(
			@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	//@Resource
	//@Qualifier("firstSqlSessionTemplate")
	//protected SqlSession firstSqlSession;

    public static void main(String[] args){
	    System.out.println(new BigDecimal(1).add(new BigDecimal(2)).pow(3));
    }
}

