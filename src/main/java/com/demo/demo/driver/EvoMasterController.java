package com.demo.demo.driver;

import com.demo.demo.DemoApplication;
import org.evomaster.client.java.controller.EmbeddedSutController;
import org.evomaster.client.java.controller.InstrumentedSutStarter;
import org.evomaster.client.java.controller.api.dto.AuthenticationDto;
import org.evomaster.client.java.controller.api.dto.SutInfoDto;
import org.evomaster.client.java.controller.problem.ProblemInfo;
import org.evomaster.client.java.controller.problem.RestProblem;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class EvoMasterController extends EmbeddedSutController {
    private ConfigurableApplicationContext ctx;
    private final int port;
    private Connection connection;

    public static void main(String[] args) {
        int port = 40100;
        EvoMasterController controller = new EvoMasterController();
        InstrumentedSutStarter starter = new InstrumentedSutStarter(controller);
        starter.start();
    }
    public EvoMasterController() {
        this.port = 40100;
    }

    @Override
    public boolean isSutRunning() {
        return ctx !=null && ctx.isRunning();
    }

    @Override
    public List<AuthenticationDto> getInfoForAuthentication() {
        return null;
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public String getDatabaseDriverName() {
        return null;
    }

    @Override
    public ProblemInfo getProblemInfo() {
        return new RestProblem(
                "http://localhost:8090/v2/api-docs",
                null
        );
    }

    @Override
    public SutInfoDto.OutputFormat getPreferredOutputFormat() {
        return SutInfoDto.OutputFormat.JAVA_JUNIT_4;
    }

    @Override
    public String getPackagePrefixesToCover() {
        return "org.javiermf.features.";
    }

    @Override
    public String startSut() {
        ctx = SpringApplication.run(DemoApplication.class, new String[]{"--server.port=0"});
        return "http://localhost:8090";
    }

    @Override
    public void stopSut() {
        ctx.stop();
    }

    @Override
    public void resetStateOfSUT() {

    }
    protected int getSutPort(){
        return (Integer)((Map) ctx.getEnvironment().getPropertySources().get("server.port").getSource())
                .get("local.server.port");

    }
}
