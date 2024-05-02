@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public UiConfiguration uiConfig() {
        return new UiConfiguration(
                "Delivery App - Store Management", // Title of your API documentation
                "1.0", // Version of your API
                "MY_AWESOME_API_KEY" // Replace with a descriptive string
        );
    }
}
