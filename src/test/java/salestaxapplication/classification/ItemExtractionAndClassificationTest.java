package salestaxapplication.classification;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ItemExtractionAndClassificationTest {

    private ItemExtractionAndClassification itemClassification1,itemClassification2;

    @BeforeEach
    void setUp() {
        itemClassification1 = new ItemExtractionAndClassification("imported chocolate");
        itemClassification2 = new ItemExtractionAndClassification(" box of perfume");
    }

    @Test
    void isImported() {
        Assertions.assertThat(itemClassification1.isImported()).isTrue();
        Assertions.assertThat(itemClassification2.isImported()).isFalse();
    }

    @Test
    void isExempt() {
        Assertions.assertThat(itemClassification1.isExempt()).isTrue();
        Assertions.assertThat(itemClassification2.isExempt()).isFalse();
    }
}