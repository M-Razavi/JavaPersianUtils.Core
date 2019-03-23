package javapersianutils.core.geography;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <h1>County</h1>
 * The County
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3 /23/2019
 */
public class County {

    /**
     * Instantiates a new County.
     *
     * @param countyName the county name
     */
    public County(String countyName) {
        this.countyName = countyName;
    }

    private String countyName;
    private Set<District> districts = new HashSet<>();

    /**
     * Gets county name.
     *
     * @return the county name
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * Sets county name.
     *
     * @param countyName the county name
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /**
     * Gets districts.
     *
     * @return the districts
     */
    public Set<District> getDistricts() {
        return districts;
    }

    /**
     * Sets districts.
     *
     * @param districts the districts
     */
    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        County county = (County) o;
        return Objects.equals(countyName, county.countyName) &&
                Objects.equals(districts, county.districts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countyName, districts);
    }

    @Override
    public String toString() {
        return countyName;
    }

    /**
     * Add districts.
     *
     * @param districts the districts
     */
    public void addDistricts(Set<District> districts) {
        this.districts.addAll(districts);
    }
}
