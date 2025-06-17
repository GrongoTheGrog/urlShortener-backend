package com.grongo.urlShortener.unitTests;


import com.grongo.urlShortener.utils.Base62;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Base62Tests {

    @Test
    public void testIfBase62CanEncodeCorrectly(){
        String encoded1 = Base62.encode(0);
        String encoded2 = Base62.encode(3844);
        String encoded3 = Base62.encode(64);
        String encoded4 = Base62.encode(70);
        String encoded5 = Base62.encode(10);

        assertThat(encoded1).isEqualTo("");
        assertThat(encoded2).isEqualTo("100");
        assertThat(encoded3).isEqualTo("12");
        assertThat(encoded4).isEqualTo("18");
        assertThat(encoded5).isEqualTo("a");
    }

    @Test
    public void testIfBase62CanDecodeCorrectly(){
        long encoded1 = Base62.decode("");
        long encoded2 = Base62.decode("100");
        long encoded3 = Base62.decode("12");
        long encoded4 = Base62.decode("18");
        long encoded5 = Base62.decode("a");

        assertThat(encoded1).isEqualTo(0L);
        assertThat(encoded2).isEqualTo(3844L);
        assertThat(encoded3).isEqualTo(64L);
        assertThat(encoded4).isEqualTo(70L);
        assertThat(encoded5).isEqualTo(10L);
    }

}
