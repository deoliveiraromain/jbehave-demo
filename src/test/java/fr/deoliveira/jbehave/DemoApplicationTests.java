package fr.deoliveira.jbehave;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContextManager;

import java.util.List;

@RunWith(JUnitReportingRunner.class)
//For JBehave to have all tests separeted, we used JUnitReportingRunner instead of SpringRunner.
//But this need a fix in order to applicationContext to be initialized correctly.
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests extends JUnitStories {

    @Autowired
    private ApplicationContext applicationContext;

    private TestContextManager testContextManager;

    public DemoApplicationTests() {
    }


    @Override
    public Configuration configuration() {
        //Fix for ApplicationContext being init correctly with spring boot
        //AS not working well:  applicationContext = new AnnotationConfigApplicationContext(DemoApplication.class);
        try {
            this.testContextManager = new TestContextManager(getClass());
            this.testContextManager.prepareTestInstance(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath())
                // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        // we can specify all classes that having steps...
        //return new InstanceStepsFactory(configuration(), new DemoStep());
        //Or use jbehave spring integration
        return new SpringStepsFactory(configuration(), applicationContext);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/*.story", "");
    }

}
