package org05.com.parameterized.test03.test.with.single.parameter;

import java.util.regex.Pattern;

public class DomainUtils {
	private static final String DOMAIN_PATTERN = "^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$";
	private static Pattern pDomainName = Pattern.compile(DOMAIN_PATTERN);
	
    public static boolean isValid(String domainName) {
        return pDomainName.matcher(domainName).find();
    }
}
