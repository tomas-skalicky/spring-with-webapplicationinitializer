package cz.skalicky.hello.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 05.08.2014
 */
@Configuration
@ComponentScan(basePackageClasses = cz.skalicky.hello.controller.PackageMarker.class)
public class ComponentScanConfig {
}
