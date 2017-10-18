﻿package demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CodeHelper {

	private static Map<String,String> map = new HashMap<String,String>();
	
	//根据code获得学科id
	public static String getCourseId(String code) {
        return map.get(code);
    }
	
	//根据路径获取code
	public static String getCode(String path) {
		int pos = path.lastIndexOf(File.separator);
		String name = path.substring(pos + 1);
		String code = name.split("_")[0];
		return code;
	}
	
    static {
        //初升高code和courseId对照表
        map.put("2201000","2001");
        map.put("2201100","2002");
        map.put("2201101","2003");
        map.put("2201102","2004");
        map.put("2201103","2005");
        map.put("2201104","2006");
        map.put("2201200","2007");
        map.put("2201201","2008");
        map.put("2201202","2009");
        map.put("2201203","2010");
        map.put("2201204","2011");
        map.put("2201300","2012");
        map.put("2201301","2013");
        map.put("2201302","2014");
        map.put("2201303","2015");
        map.put("2201400","2016");
        map.put("2201401","2017");
        map.put("2201402","2018");
        map.put("2201403","2019");
        map.put("2201500","2020");
        map.put("2201501","2021");
        map.put("2201502","2022");
        map.put("2201503","2023");
        map.put("2201504","2024");
        map.put("2202000","2025");
        map.put("2202100","2026");
        map.put("2202101","2027");
        map.put("2202102","2028");
        map.put("2202200","2029");
        map.put("2202201","2030");
        map.put("2202202","2031");
        map.put("2202300","2032");
        map.put("2202301","2033");
        map.put("2202302","2034");
        map.put("2202303","2035");
        map.put("2203000","2036");
        map.put("2203100","2037");
        map.put("2203101","2038");
        map.put("2203102","2039");
        map.put("2203103","2040");
        map.put("2203200","2041");
        map.put("2203201","2042");
        map.put("2203202","2043");
        map.put("2203203","2044");
        map.put("2204000","2046");
        map.put("2204100","2047");
        map.put("2204101","2048");
        map.put("2204102","2049");
        map.put("2204200","2050");
        map.put("2204201","2051");
        map.put("2204202","2052");
        map.put("2205000","2053");
        map.put("2205100","2054");
        map.put("2205101","2055");
        map.put("2205102","2056");
        map.put("2205103","2057");
        map.put("2205200","2058");
        map.put("2205201","2059");
        map.put("2205202","2060");
        map.put("2205203","2061");
        map.put("2205300","2062");
        map.put("2205301","2063");
        map.put("2205302","2064");
        map.put("2206000","2065");
        map.put("2206100","2066");
        map.put("2206101","2067");
        map.put("2206102","2068");
        map.put("2206103","2069");
        map.put("2206200","2070");
        map.put("2206201","2071");
        map.put("2206202","2072");
        map.put("2207000","2073");
        map.put("2207100","2074");
        map.put("2207101","2075");
        map.put("2207102","2076");
        map.put("2207200","2077");
        map.put("2207201","2078");
        map.put("2207202","2079");
        map.put("2207203","2080");
        map.put("2207300","2081");
        map.put("2207301","2082");
        map.put("2207302","2083");
        map.put("2207400","2084");
        map.put("2207401","2085");
        map.put("2207402","2086");
        map.put("2208000","2087");
        map.put("2208100","2088");
        map.put("2208101","2089");
        map.put("2208102","2090");
        map.put("2208103","2091");
        map.put("2208200","2092");
        map.put("2208201","2093");
        map.put("2208202","2094");
        map.put("2208203","2095");
        map.put("2209000","2096");
        map.put("2209100","2097");
        map.put("2209101","2098");
        map.put("2209102","2099");
        map.put("2209103","2100");
        map.put("2209200","2101");
        map.put("2209201","2102");
        map.put("2209202","2103");
        map.put("2209203","2104");
        map.put("2210000","2105");
        map.put("2210100","2106");
        map.put("2210101","2107");
        map.put("2210102","2108");
        map.put("2210200","2109");
        map.put("2210201","2110");
        map.put("2210202","2111");
        map.put("2210300","2112");
        map.put("2210302","2114");
        map.put("2210303","2115");
        map.put("2211000","2116");
        map.put("2211001","2113");
        map.put("2211002","2114");
        map.put("2211100","2117");
        map.put("2211101","2118");
        map.put("2211102","2119");
        map.put("2211103","2120");
        map.put("2211104","2121");
        map.put("2211200","2122");
        map.put("2211201","2123");
        map.put("2211202","2124");
        map.put("2211203","2125");
        map.put("2211204","2126");
        map.put("2211300","2127");
        map.put("2211301","2128");
        map.put("2211302","2129");
        map.put("2211400","2130");
        map.put("2211401","2131");
        map.put("2211402","2132");
        map.put("2212000","2133");
        map.put("2212001","2134");
        map.put("2212002","2135");
        map.put("2212003","2136");
        map.put("2212004","2137");
        map.put("2212005","2138");
        map.put("2212006","2139");
        map.put("2212007","2140");
        map.put("2212008","2141");
        map.put("2301000","2150");
        map.put("2301100","2151");
        map.put("2301101","2152");
        map.put("2301105","2167");
        map.put("2301120","2153");
        map.put("2301121","2154");
        map.put("2301122","2155");
        map.put("2301123","2156");
        map.put("2301124","2157");
        map.put("2301125","2158");
        map.put("2301130","2159");
        map.put("2301131","2160");
        map.put("2301132","2161");
        map.put("2301140","2162");
        map.put("2301141","2163");
        map.put("2301142","2164");
        map.put("2301143","2165");
        map.put("2301144","2166");
        map.put("2301200","2168");
        map.put("2301201","2169");
        map.put("2301202","2170");
        map.put("2301203","2171");
        map.put("2301204","2172");
        map.put("2301300","2173");
        map.put("2301301","2174");
        map.put("2301302","2175");
        map.put("2301303","2176");
        map.put("2301304","2177");
        map.put("2301305","2178");
        map.put("2301306","2179");
        map.put("2301400","2180");
        map.put("2301401","2181");
        map.put("2301402","2182");
        map.put("2301403","2183");
        map.put("2301404","2184");
        map.put("2302000","2185");
        map.put("2302100","2186");
        map.put("2302101","2187");
        map.put("2302102","2188");
        map.put("2302103","2189");
        map.put("2302104","2190");
        map.put("2302105","2191");
        map.put("2302200","2192");
        map.put("2302201","2193");
        map.put("2302202","2194");
        map.put("2302300","2195");
        map.put("2302301","2196");
        map.put("2302302","2197");
        map.put("2302303","2198");
        map.put("2302304","2199");
        map.put("2302305","2200");
        map.put("2302306","2201");
        map.put("2303000","2202");
        map.put("2303100","2203");
        map.put("2303103","2212");
        map.put("2303104","2213");
        map.put("2303105","2214");
        map.put("2303110","2204");
        map.put("2303111","2205");
        map.put("2303112","2206");
        map.put("2303113","2207");
        map.put("2303114","2208");
        map.put("2303120","2209");
        map.put("2303121","2210");
        map.put("2303122","2211");
        map.put("2303200","2215");
        map.put("2303201","2216");
        map.put("2303202","2217");
        map.put("2303204","2221");
        map.put("2303230","2218");
        map.put("2303231","2219");
        map.put("2303232","2220");
        map.put("2303300","2222");
        map.put("2303301","2223");
        map.put("2303302","2224");
        map.put("2303303","2225");
        map.put("2303304","2226");
        map.put("2304000","2227");
        map.put("2304100","2228");
        map.put("2304101","2229");
        map.put("2304102","2230");
        map.put("2304103","2231");
        map.put("2304104","2232");
        map.put("2304200","2233");
        map.put("2304201","2234");
        map.put("2304220","2235");
        map.put("2304221","2236");
        map.put("2304222","2237");
        map.put("2304223","2238");
        map.put("2304230","2239");
        map.put("2304231","2240");
        map.put("2304232","2241");
        map.put("2304240","2242");
        map.put("2304241","2243");
        map.put("2304242","2244");
        map.put("2304243","2245");
        map.put("2304300","2246");
        map.put("2304301","2247");
        map.put("2304302","2248");
        map.put("2304303","2249");
        map.put("2304304","2250");
        map.put("2304305","2251");
        map.put("2304400","2252");
        map.put("2304401","2253");
        map.put("2304402","2254");
        map.put("2304403","2255");
        map.put("2304500","2256");
        map.put("2304501","2257");
        map.put("2304502","2258");
        map.put("2304503","2259");
        map.put("2304600","2260");
        map.put("2304602","2265");
        map.put("2304603","2266");
        map.put("2304610","2261");
        map.put("2304611","2262");
        map.put("2304612","2263");
        map.put("2304613","2264");
        map.put("2304700","2267");
        map.put("2304701","2268");
        map.put("2304702","2269");
        map.put("2401000","2272");
        map.put("2401100","2273");
        map.put("2401110","2274");
        map.put("2401111","2275");
        map.put("2401112","2276");
        map.put("2401113","2277");
        map.put("2401120","2278");
        map.put("2401121","2279");
        map.put("2401122","2280");
        map.put("2401123","2281");
        map.put("2401130","2282");
        map.put("2401131","2283");
        map.put("2401132","2284");
        map.put("2401133","2285");
        map.put("2401200","2286");
        map.put("2401210","2287");
        map.put("2401211","2288");
        map.put("2401212","2289");
        map.put("2401220","2290");
        map.put("2401221","2291");
        map.put("2401222","2292");
        map.put("2401230","2293");
        map.put("2401231","2294");
        map.put("2401232","2295");
        map.put("2401233","2296");
        map.put("2401300","2297");
        map.put("2401310","2298");
        map.put("2401311","2299");
        map.put("2401312","2300");
        map.put("2401313","2301");
        map.put("2401320","2302");
        map.put("2401321","2303");
        map.put("2401322","2304");
        map.put("2401330","2305");
        map.put("2401331","2306");
        map.put("2401332","2307");
        map.put("2401333","2308");
        map.put("2401340","2309");
        map.put("2401341","2310");
        map.put("2401342","2311");
        map.put("2401400","2312");
        map.put("2401410","2313");
        map.put("2401411","2314");
        map.put("2401412","2315");
        map.put("2401420","2316");
        map.put("2401421","2317");
        map.put("2401422","2318");
        map.put("2401423","2319");
        map.put("2401500","2320");
        map.put("2401510","2321");
        map.put("2401511","2322");
        map.put("2401512","2323");
        map.put("2401513","2324");
        map.put("2401514","2325");
        map.put("2401520","2326");
        map.put("2401521","2327");
        map.put("2401522","2328");
        map.put("2401523","2329");
        map.put("2401524","2330");
        map.put("2401530","2331");
        map.put("2401531","2332");
        map.put("2401532","2333");
        map.put("2401600","2334");
        map.put("2401601","2335");
        map.put("2401602","2336");
        map.put("2401603","2337");
        map.put("2402000","2338");
        map.put("2402100","2339");
        map.put("2402110","2340");
        map.put("2402111","2341");
        map.put("2402112","2342");
        map.put("2402113","2343");
        map.put("2402120","2344");
        map.put("2402121","2345");
        map.put("2402122","2346");
        map.put("2402130","2347");
        map.put("2402200","2348");
        map.put("2402210","2349");
        map.put("2402211","2350");
        map.put("2402212","2351");
        map.put("2402220","2352");
        map.put("2402221","2353");
        map.put("2402222","2354");
        map.put("2402300","2355");
        map.put("2402310","2356");
        map.put("2402311","2357");
        map.put("2402312","2358");
        map.put("2402320","2359");
        map.put("2402321","2360");
        map.put("2402322","2361");
        map.put("2402400","2362");
        map.put("2402410","2363");
        map.put("2402411","2364");
        map.put("2402412","2365");
        map.put("2402420","2366");
        map.put("2402500","2367");
        map.put("2402510","2368");
        map.put("2402520","2369");
        map.put("2402530","2370");
        map.put("2402531","2371");
        map.put("2402532","2372");
        map.put("2402540","2373");
        map.put("2402541","2374");
        map.put("2402542","2375");
        map.put("2403000","2376");
        map.put("2403100","2377");
        map.put("2403101","2378");
        map.put("2403102","2379");
        map.put("2403103","2380");
        map.put("2403104","2381");
        map.put("2403105","2382");
        map.put("2403200","2383");
        map.put("2403201","2384");
        map.put("2403202","2385");
        map.put("2403203","2386");
        map.put("2403300","2387");
        map.put("2403301","2388");
        map.put("2403302","2389");
        map.put("2501000","2390");
        map.put("2501100","2391");
        map.put("2501110","2392");
        map.put("2501111","2393");
        map.put("2501112","2394");
        map.put("2501113","2395");
        map.put("2501114","2396");
        map.put("2501120","2397");
        map.put("2501121","2398");
        map.put("2501122","2399");
        map.put("2501123","2400");
        map.put("2501124","2401");
        map.put("2501125","2402");
        map.put("2501200","2403");
        map.put("2501210","2404");
        map.put("2501211","2405");
        map.put("2501212","2406");
        map.put("2501220","2407");
        map.put("2501221","2408");
        map.put("2501222","2409");
        map.put("2501223","2410");
        map.put("2501230","2411");
        map.put("2501231","2412");
        map.put("2501232","2413");
        map.put("2501233","2414");
        map.put("2501240","2415");
        map.put("2501241","2416");
        map.put("2501242","2417");
        map.put("2501250","2418");
        map.put("2501251","2419");
        map.put("2501252","2420");
        map.put("2501260","2421");
        map.put("2501261","2422");
        map.put("2501262","2423");
        map.put("2501263","2424");
        map.put("2502000","2425");
        map.put("2502100","2426");
        map.put("2502110","2427");
        map.put("2502111","2428");
        map.put("2502112","2429");
        map.put("2502113","2430");
        map.put("2502120","2431");
        map.put("2502121","2432");
        map.put("2502122","2433");
        map.put("2502130","2434");
        map.put("2502131","2435");
        map.put("2502132","2436");
        map.put("2502133","2437");
        map.put("2502134","2438");
        map.put("2502200","2439");
        map.put("2502210","2440");
        map.put("2502211","2441");
        map.put("2502212","2442");
        map.put("2502213","2443");
        map.put("2502220","2444");
        map.put("2502221","2445");
        map.put("2502222","2446");
        map.put("2502223","2447");
        map.put("2502230","2448");
        map.put("2502231","2449");
        map.put("2502232","2450");
        map.put("2502233","2451");
        map.put("2502240","2452");
        map.put("2502241","2453");
        map.put("2502242","2454");
        map.put("2502243","2455");
        map.put("2502244","2456");
        map.put("2502300","2457");
        map.put("2502310","2458");
        map.put("2502311","2459");
        map.put("2502312","2460");
        map.put("2502313","2461");
        map.put("2502314","2462");
        map.put("2502320","2463");
        map.put("2502321","2464");
        map.put("2502322","2465");
        map.put("2502330","2466");
        map.put("2502331","2467");
        map.put("2502332","2468");
        map.put("2502333","2469");
        map.put("2502340","2470");
        map.put("2502341","2471");
        map.put("2502342","2472");
        map.put("2502350","2473");
        map.put("2502351","2474");
        map.put("2502352","2475");
        map.put("2502353","2476");
        map.put("2502360","2477");
        map.put("2502361","2478");
        map.put("2502362","2479");
        map.put("2503000","2480");
        map.put("2503100","2481");
        map.put("2503110","2482");
        map.put("2503111","2483");
        map.put("2503112","2484");
        map.put("2503120","2485");
        map.put("2503121","2486");
        map.put("2503122","2487");
        map.put("2503130","2488");
        map.put("2503131","2489");
        map.put("2503132","2490");
        map.put("2503133","2491");
        map.put("2503140","2492");
        map.put("2503141","2493");
        map.put("2503142","2494");
        map.put("2503150","2495");
        map.put("2503151","2496");
        map.put("2503152","2497");
        map.put("2503153","2498");
        map.put("2503200","2499");
        map.put("2503210","2500");
        map.put("2503211","2501");
        map.put("2503212","2502");
        map.put("2503213","2503");
        map.put("2503214","2504");
        map.put("2503220","2505");
        map.put("2503221","2506");
        map.put("2503222","2507");
        map.put("2503223","2508");
        map.put("2503224","2509");
        map.put("2503230","2510");
        map.put("2503231","2511");
        map.put("2503232","2512");
        map.put("2503233","2513");
        map.put("2503234","2514");
        map.put("2503300","2515");
        map.put("2503310","2516");
        map.put("2503311","2517");
        map.put("2503312","2518");
        map.put("2503313","2519");
        map.put("2503320","2520");
        map.put("2503321","2521");
        map.put("2503322","2522");
        map.put("2503323","2523");
        map.put("2503330","2524");
        map.put("2503331","2525");
        map.put("2503332","2526");
    }
    
}