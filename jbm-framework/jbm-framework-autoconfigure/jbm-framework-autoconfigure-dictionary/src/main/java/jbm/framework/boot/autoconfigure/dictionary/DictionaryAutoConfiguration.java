package jbm.framework.boot.autoconfigure.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.data.keyvalue.core.mapping.context.KeyValueMappingContext;
import org.springframework.data.map.MapKeyValueAdapter;

import com.jbm.autoconfig.dic.DictionaryScanner;
import com.jbm.autoconfig.dic.DictionaryTemplate;

@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@ConditionalOnProperty(prefix = DictionaryProperties.PREFIX, name = "basepackage")
@EnableConfigurationProperties({ DictionaryProperties.class })
public class DictionaryAutoConfiguration {
	// private final static Logger logger =
	// LoggerFactory.getLogger(DictionaryAutoConfiguration.class);

	@Autowired
	private DictionaryProperties dictionaryProperties;
	@Autowired
	private ConfigurableEnvironment environment;
//	@Autowired(required = false)
//	private List<KeyValueTemplate> keyValueTemplates;

	private KeyValueTemplate keyValueTemplate;

	// private RealRestTemplate realRestTemplate =
	// RestTemplateFactory.getInstance().createRealRestTemplate();

	/**
	 * 常量发现和共享
	 * 
	 * @param applicationContext
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DictionaryTemplate dictionaryCache(ApplicationContext applicationContext) throws Exception {
//		if (CollectionUtils.isNotEmpty(keyValueTemplates))
//			keyValueTemplate = keyValueTemplates.get(0);
		// 新生产一个缓存对象
//		if (keyValueTemplate == null) {
		KeyValueMappingContext<?, ?> context = new KeyValueMappingContext<>();
		context.setApplicationEventPublisher(applicationContext);
		keyValueTemplate = new KeyValueTemplate(new MapKeyValueAdapter(), context);
//		}
		String app = environment
				.resolvePlaceholders("${spring.application.name:" + dictionaryProperties.getApplication() + "}");
		DictionaryTemplate dictionaryCache = new DictionaryTemplate(keyValueTemplate, app);
		DictionaryScanner dictionaryScanner = new DictionaryScanner(applicationContext, dictionaryCache,
				dictionaryProperties.getBasepackage());
		dictionaryScanner.scanner();
		return dictionaryCache;
	}

}
