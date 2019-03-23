package javapersianutils.core.geography;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <h1>Pro</h1>
 * The Pro
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3 /23/2019
 */
public class Province {

    /**
     * The Province name.
     */
    public String provinceName;
    /**
     * The Counties.
     */
    public Set<County> counties = new HashSet<>();

    /**
     * Instantiates a new Province.
     *
     * @param provinceName the province name
     */
    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * Gets province name.
     *
     * @return the province name
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * Sets province name.
     *
     * @param provinceName the province name
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * Gets counties.
     *
     * @return the counties
     */
    public Set<County> getCounties() {
        return counties;
    }

    /**
     * Sets counties.
     *
     * @param counties the counties
     */
    public void setCounties(Set<County> counties) {
        this.counties = counties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return Objects.equals(provinceName, province.provinceName) &&
                Objects.equals(counties, province.counties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceName, counties);
    }

    @Override
    public String toString() {
        return provinceName;
    }

    /**
     * Add counties.
     *
     * @param counties the counties
     */
    public void addCounties(Set<County> counties) {
        this.counties.addAll(counties);
    }
}