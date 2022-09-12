package salestaxapplication.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxUtilsTest {

    @Test
    void totalAmountRoundup() {
        Assertions.assertThat(TaxUtils.totalAmountRoundup(11.83125)).isEqualTo(11.83);
    }

    @Test
    void taxRoundup() {
        Assertions.assertThat(TaxUtils.taxRoundup(11.83125)).isEqualTo(11.85);
    }
}