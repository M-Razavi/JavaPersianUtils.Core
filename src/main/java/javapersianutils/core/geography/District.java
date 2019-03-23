package javapersianutils.core.geography;

import java.util.Objects;
import java.util.Set;

/**
 * <h1>District</h1>
 * The District
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3 /23/2019
 */
public class District {
    private String districtName;
    private Set<City> cities;

    public District(String districtName) {
        this.districtName = districtName;
    }

    /**
     * Gets district name.
     *
     * @return the district name
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * Sets district name.
     *
     * @param districtName the district name
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * Gets cities.
     *
     * @return the cities
     */
    public Set<City> getCities() {
        return cities;
    }

    /**
     * Sets cities.
     *
     * @param cities the cities
     */
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(districtName, district.districtName) &&
                Objects.equals(cities, district.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(districtName, cities);
    }

    @Override
    public String toString() {
        return districtName;
    }
}
