package boot.support;

import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class AbstractMybatisDaoSupport<T>{
	
	@Bean(name="firstDataSource")  
    @ConfigurationProperties(prefix="datasource.first")  
	@Primary
    public DataSource firstDataSource() {  
        return DataSourceBuilder.create().build();  
    }  
      
    
    @Bean(name = "firstSqlSessionFactory")
	public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/mybatis-config.xml"));
		//bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*Mapper.xml"));
		return bean.getObject();
	}
    
    @Bean(name = "firstTransactionManager")
    @Primary
	public DataSourceTransactionManager firstTransactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
    
    @Bean(name = "firstSqlSessionTemplate")
	public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
    
    @Bean(name="secondaryDataSource")  
    @ConfigurationProperties(prefix="datasource.secondary")  
    public DataSource secondaryDataSource() {  
        return DataSourceBuilder.create().build();  
    } 
    
    @Bean(name = "secondSqlSessionFactory")
	public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper1/mybatis-config.xml"));
		//bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper1/*Mapper.xml"));
		return bean.getObject();
	}
    
	@Bean(name = "secondTransactionManager")
	public DataSourceTransactionManager secondTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "secondSqlSessionTemplate")
	public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

    //@Autowired
	@Resource
    @Qualifier("firstSqlSessionTemplate")
	protected SqlSession firstSqlSession;
	
    //@Autowired
	@Resource
    @Qualifier("secondSqlSessionTemplate")
	protected SqlSession secondSqlSession;
	
	protected List<T> selectList(SqlSession sqlSession,String statement,Object parameter){
		return sqlSession.selectList(statement, parameter);
	}

	protected T selectOne(SqlSession sqlSession,String statement,Object parameter){
		return sqlSession.selectOne(statement,parameter);
	}
	
	protected void insert(SqlSession sqlSession,String statement,T parameter){
		sqlSession.insert(statement, parameter); 
	}
	
	protected void update(SqlSession sqlSession,String statement,T parameter){
		sqlSession.update(statement, parameter); 
	}
	

}
