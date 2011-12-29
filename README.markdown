# GAEOfy with VRaptor

Import target/gaeofy-0.0.4.jar

Then configure it to be scanned

	<context-param>
		<param-name>br.com.caelum.vraptor.packages</param-name>
		<param-value>com.squaremarks.gaeofy</param-value>
	</context-param>


Now create a class to register your entities like this:
	
	import static com.squaremarks.gaeofy.ofy.GAEOfy.register;
	
	@Component
	@ApplicationScoped
	public class ObjectifyRegister {
	
		static {
			
			register(User.class, Address.class)
				.and(Product.class, StockItem.class)
				.and(Stuff.class);
			
			//or call ObjectifyService.register() directly
		}

	}
	
done :D

## VRaptorGAE filter

Use the VRaptorGAE filter to enable /_ah/admin, /appstats and /remote_api URIs

	<filter>
		<filter-name>vraptor</filter-name>
		<filter-class>br.com.caelum.vraptor.VRaptorGAE</filter-class>
	</filter>

## Using the DataStoreTemplate:

	Inject anywhere you want
	You can access Objectfy through ofy() and ofyAsync()

	@Resource
	public class SampleController {
	
		private final Result result;
		private final DataStoreTemplate ds;
	
		public SampleController(Result result, DataStoreTemplate ds) {
			this.result = result;
			this.ds = ds;
		}
		
		@Post("/create")
		public void createForm(Sample sample) {

			ds.save(sample);
			ds.saveAsync(sample);
		}
	
		@Get("/samples")
		public void list() {
	
			List<Sample> list = ds.list(Sample.class);
			serialize(list);
		}
	
		@Get("/filter")
		public void filter(String filter) {

			List<Sample> list = ds.query(Sample.class).filter("name", filter).list();
			serialize(list);
		}
	
		private void serialize(List<Sample> list) {
			result.use(json()).from(list).serialize();
		}
	
	}

## Creating Repositories

	interface UserRepository extends BasicRepository<User> {}


Interfaces included

- BasicRepository
- SaveRepository
- SaveAsyncRepository
- RemoveRepository
- ListRepository
- LoadRespository

## Blank project

soon :)
