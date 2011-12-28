# GAEOfy with VRaptor

Import target/gaeofy-0.0.2.jar 
Then configure it to be scanned

`
<context-param>
	<param-name>br.com.caelum.vraptor.packages</param-name>
	<param-value>com.squaremarks.gaeofy</param-value>
</context-param>
`

Now create a class to register your entities like this:

`

@Component
@ApplicationScoped
public class ObjectifyRegister {
	
	static {
		register(Event.class);
		register(Ticket.class);
	}

}

`

and you're done :)

## Using the DataStoreTemplate:

`
@Resource
public class SampleController {
	
	private final Result result;
	private final DataStoreTemplate ds;
	
	public ThingController(Result result, DataStoreTemplate ds) {
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

		List<Sample> list = ds.ofy().query(Sample.class).filter("name", filter).list();
		serialize(list);
	}
	
	private void serialize(List<Sample> list) {
		result.use(json()).from(list).serialize();
	}
	
}
`

## Creating Repositories

`
interface UserRepository extends BasicRepository<User> {}
`

Interfaces included

- BasicRepository
- SaveRepository
- SaveAsyncRepository
- RemoveRepository
- ListRepository
- LoadRespository

## Blank project

soon :)
