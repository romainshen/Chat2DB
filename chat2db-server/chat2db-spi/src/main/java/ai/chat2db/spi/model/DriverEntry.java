
package ai.chat2db.spi.model;

import java.io.Serializable;
import java.sql.Driver;

import ai.chat2db.spi.config.DriverConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author jipengfei
 * @version : DriverEntry.java
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DriverEntry  implements Serializable {
    private static final long serialVersionUID = 1L;

    private DriverConfig driverConfig;

    private Driver driver;

}