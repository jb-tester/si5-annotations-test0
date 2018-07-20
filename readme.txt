@RunWith(SpringRunner.class)
+@DirtiesContext
+public class BeanNameTests {
+
+	@SuppressWarnings("unused")
+	@Autowired
+	private EventDrivenConsumer eipMethod;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	@Qualifier("eipMethod.handler")
+	private MessageHandler eipMethodHandler;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	private EventDrivenConsumer eipBean;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	@Qualifier("eipBean.handler")
+	private MessageHandler eipBeanHandler;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	private EventDrivenConsumer eipBean2;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	@Qualifier("eipBean2.handler")
+	private MessageHandler eipBean2Handler;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	private SourcePollingChannelAdapter eipMethodSource;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	@Qualifier("eipMethodSource.source")
+	private MessageSource<?> eipMethodSourceSource;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	private SourcePollingChannelAdapter eipSource;
+
+	@SuppressWarnings("unused")
+	@Autowired
+	@Qualifier("eipSource.source")
+	private MessageSource<?> eipSourceSource;
+
+	@Test
+	public void contextLoads() {
+
+	}
+
+	@Configuration
+	@EnableIntegration
+	@EnableIntegrationManagement
+	public static class Config {
+
+		@Bean
+		public MeterRegistry meterRegistry() {
+			return new SimpleMeterRegistry();
+		}
+
+		@ServiceActivator(inputChannel = "channel")
+		@EndpointId("eipMethod")
+		public void service(String in) {
+			if ("bar".equals(in)) {
+				throw new RuntimeException("testErrorCount");
+			}
+		}
+
+		@Bean("eipBean.handler")
+		@EndpointId("eipBean")
+		@ServiceActivator(inputChannel = "channel2")
+		public MessageHandler replyingHandler() {
+			return new AbstractReplyProducingMessageHandler() {
+
+				@Override
+				protected Object handleRequestMessage(Message<?> requestMessage) {
+					return null;
+				}
+
+			};
+		}
+
+		@Bean("eipBean2.handler")
+		@EndpointId("eipBean2")
+		@ServiceActivator(inputChannel = "channel3")
+		public MessageHandler handler() {
+			return m -> { };
+		}
+
+		@EndpointId("eipMethodSource")
+		@InboundChannelAdapter(channel = "channel3", poller = @Poller(fixedDelay = "5000"))
+		public String pojoSource() {
+			return null;
+		}
+
+		@Bean("eipSource.source")
+		@EndpointId("eipSource")
+		@InboundChannelAdapter(channel = "channel3", poller = @Poller(fixedDelay = "5000"))
+		public MessageSource<?> source() {
+			return () -> null;
+		}
+
+	}
+
+}