package com.devmind.adnotari;

import java.lang.annotation.Documented;

@Documented
public @interface Antet {
    String autor();
    String data();
    String ultimaModificare() default "N/A";

    // Note use of array
    String[] revieweri();

}
