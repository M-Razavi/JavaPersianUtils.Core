package javapersianutils.core.geography;

import org.junit.jupiter.api.Test;

import javax.management.relation.RelationNotFoundException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IranTest {

    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
                - TimeUnit.HOURS.toMinutes(hours);
        // avoid -4:-30 issue
        minutes = Math.abs(minutes);

        String result = "";
        if (hours > 0) {
            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
        } else {
            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
        }

        return result;
    }

    @Test
    public void test_IranGetProvincesCount_IsCorrect() {
        assertEquals(31, Iran.getProvinces().size());
    }

    @Test
    public void test_IranCitiesCount_IsCorrect() {
        assertEquals(1242, Iran.getCities().size());
    }

    @Test
    public void test_provinceCounties_IsCorrect() throws RelationNotFoundException {
        Province tehran = Iran.getProvinces().stream().filter(province -> province.getProvinceName().equalsIgnoreCase("تهران")).findFirst().orElseThrow(RelationNotFoundException::new);
        assertEquals(15, tehran.getCounties().size());

        Province esfahan = Iran.getProvinces().stream().filter(province -> province.getProvinceName().equalsIgnoreCase("اصفهان")).findFirst().orElseThrow(RelationNotFoundException::new);
        assertEquals(24, esfahan.getCounties().size());

        Province khozestan = Iran.getProvinces().stream().filter(province -> province.getProvinceName().equalsIgnoreCase("خوزستان")).findFirst().orElseThrow(RelationNotFoundException::new);
        assertEquals(27, khozestan.getCounties().size());
    }

    @Test
    public void test_countyDistricts_IsCorrect() throws RelationNotFoundException {
        Province esfahanPrv = Iran.getProvinces().stream().filter(province -> province.getProvinceName().equalsIgnoreCase("اصفهان")).findFirst().orElseThrow(RelationNotFoundException::new);
        County esfahanCnty = esfahanPrv.getCounties().stream().filter(county -> county.getCountyName().equalsIgnoreCase("اصفهان")).findFirst().orElseThrow(RelationNotFoundException::new);
        assertEquals(6, esfahanCnty.getDistricts().size());

        Province khozestanPrv = Iran.getProvinces().stream().filter(province -> province.getProvinceName().equalsIgnoreCase("خوزستان")).findFirst().orElseThrow(RelationNotFoundException::new);
        County abadanCnty = khozestanPrv.getCounties().stream().filter(county -> county.getCountyName().equalsIgnoreCase("آبادان")).findFirst().orElseThrow(RelationNotFoundException::new);
        assertEquals(2, abadanCnty.getDistricts().size());
    }

    @Test
    public void test_districtCities_IsCorrect() throws RelationNotFoundException {
        Province esfahanPrv = Iran.getProvinces().stream().filter(province -> province.getProvinceName().equalsIgnoreCase("اصفهان")).findFirst().orElseThrow(RelationNotFoundException::new);
        County mobarakehCnty = esfahanPrv.getCounties().stream().filter(county -> county.getCountyName().equalsIgnoreCase("مبارکه")).findFirst().orElseThrow(RelationNotFoundException::new);
        District markaziDstr = mobarakehCnty.getDistricts().stream().filter(county -> county.getDistrictName().equalsIgnoreCase("مرکزی")).findFirst().orElseThrow(RelationNotFoundException::new);
        assertEquals(4, markaziDstr.getCities().size());

        String[] ids = TimeZone.getAvailableIDs();
        for (String id : ids) {
            System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
        }

        System.out.println("\nTotal TimeZone ID " + ids.length);
    }

    @Test
    public void test_cityClass_success() {
        City esfahanCity = new City(
                "اصفهان",
                "مبارکه",
                "مرکزی",
                "مبارکه",
                70208);

        assertTrue(esfahanCity.getProvinceName().equalsIgnoreCase("اصفهان"));
        assertTrue(esfahanCity.getCountyName().equalsIgnoreCase("مبارکه"));
        assertTrue(esfahanCity.getDistrictName().equalsIgnoreCase("مرکزی"));
        assertTrue(esfahanCity.getCityName().equalsIgnoreCase("مبارکه"));
        assertTrue(esfahanCity.getCityDivisionCode()==70208);
    }
}