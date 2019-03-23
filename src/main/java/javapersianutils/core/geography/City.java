package javapersianutils.core.geography;

import java.util.Objects;

/**
 * <h1>City</h1>
 * The City
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3 /23/2019
 */
public class City {


    private String provinceName;
    private String countyName;
    private String districtName;
    private String cityName;
    private int cityDivisionCode;

    /**
     * Instantiates a new City.
     *
     * @param provinceName     the province name
     * @param countyName       the county name
     * @param districtName     the district name
     * @param cityName         the city name
     * @param cityDivisionCode the city division code
     */
    public City(String provinceName, String countyName, String districtName, String cityName, int cityDivisionCode) {
        this.provinceName = provinceName;
        this.countyName = countyName;
        this.districtName = districtName;
        this.cityName = cityName;
        this.cityDivisionCode = cityDivisionCode;
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
     * Gets City name.
     *
     * @return the City name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets City name.
     *
     * @param cityName the City name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Gets City division code.
     *
     * @return the City division code
     */
    public int getCityDivisionCode() {
        return cityDivisionCode;
    }

    /**
     * Sets City division code.
     *
     * @param cityDivisionCode the City division code
     */
    public void setCityDivisionCode(int cityDivisionCode) {
        this.cityDivisionCode = cityDivisionCode;
    }

    @Override
    public String toString() {
        return cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(provinceName, city.provinceName) &&
                Objects.equals(countyName, city.countyName) &&
                Objects.equals(districtName, city.districtName) &&
                Objects.equals(cityName, city.cityName) &&
                Objects.equals(cityDivisionCode, city.cityDivisionCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceName, countyName, districtName, cityName, cityDivisionCode);
    }
}

