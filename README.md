JAVAPersianUtils.Core
=======
<div dir="rtl">

[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/com.github.m-razavi/java-persian-utils.core/master/LICENSE.txt)
[![codebeat badge](https://codebeat.co/badges/d873e93d-6ded-46c2-a1d6-5cfa4afa2ae4)](https://codebeat.co/projects/github-com-m-razavi-javapersianutils-core-master)
[![Coverage Status](https://coveralls.io/repos/github/M-Razavi/JavaPersianUtils.Core/badge.svg)](https://coveralls.io/github/M-Razavi/JavaPersianUtils.Core)
[![build_status](https://api.travis-ci.com/M-Razavi/JavaPersianUtils.Core.svg?branch=master)](https://travis-ci.com/M-Razavi/JavaPersianUtils.Core)
[![Javadocs](https://www.javadoc.io/badge/com.github.m-razavi/java-persian-utils.core.svg)](https://www.javadoc.io/doc/com.github.m-razavi/java-persian-utils.core)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.m-razavi/java-persian-utils.core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.m-razavi/java-persian-utils.core)



[JavaPersianUtils.Core](https://github.com/M-Razavi/JavaPersianUtils.Core) کتابخانه‌ای است متشکل از متدهای الحاقی کمکی جهت کار با زبان و تاریخ فارسی، در برنامه‌های مبتنی بر Java 8.0  و بالاتر است.
این کتابخانه بر مبنای کتابخانه [DNTPersianUtils.Core](https://github.com/VahidN/DNTPersianUtils.Core) توسعه داده شده است.
و به مرور  تمامی مواردی که در آن وجود دارد برای جاوا پیاده سازی می گردد.
برای استفاده از آن میتوانید آنرا از Maven Central در یافت کنید:
</div>

```
<dependency>
  <groupId>com.github.m-razavi</groupId>
  <artifactId>java-persian-utils.core</artifactId>
</dependency>
```


لیست متدها و امکانات این کتابخانه
-----------------


|نام متد/امکانات|مثال|خروجی نمونه|
| -------| :------: | :------: |
|&#x202b; نرمال کردن متون. پارامتر آن قابلیت ترکیب را دارد. | "'تست'".NormalizePersianText | «تست» |
| لیست مناطق و استان‌ها | Iran.Provinces | Iran.Provinces لیست تو در توی استان‌ها و شهرهای ایران |
|آیا عبارت مدنظر حاوی حروف فارسی است؟|"Abc تست".ContainsFarsi()|true|
|اصلاح ی و ک عربی به فارسی|"می‌شود".ApplyCorrectYeKe()|می‌شود|
|راست به چپ کردن یک متن ساده مخلوط برای نمایش در محیط‌های چپ به راست مانند فید خوان‌ها|"سلام Abc".ApplyRle()|Abc سلام|
|محاسبه سن|DateTime.Now.AddYears(-9).GetAge()|9|

<!--
|مجموعه کلمات بی‌اثر زبان فارسی| PersianStopwords.List | مفید برای تنظیمات جستجوهای تمام متنی |
|نمایش فارسی روز دریافتی|dt.ToPersianDateTextify()|سه شنبه ۲۱ دی ۱۳۹۵|
|نمایش دوستانه‌ی یک تاریخ و ساعت انگلیسی به شمسی|dt.ToFriendlyPersianDateTextify()|&#x202b;۱۰ روز قبل، سه شنبه ۲۱ دی ۱۳۹۵، ساعت ۱۰:۲۰|
|تبدیلگر عدد به حروف|1234567.NumberToText(Language.Persian)|یک میلیون و دویست و سی و چهار هزار و پانصد و شصت و هفت|
|نگارش اصلاح شده‌ی فرهنگ فارسی|PersianCulture.Instance|در این فرهنگ تاریخ میلادی با شمسی جایگزین شده‌است|
|تبدیل تاریخ و زمان رشته‌ای شمسی به میلادی|"1395/11/3 7:30".ToGregorianDateTime()|new DateTime(2017, 1, 22, 7, 30, 0)|
|تبدیل تاریخ میلادی به شمسی|dt.ToLongPersianDateString()|&#x202b;21 دی 1395|
|تبدیل تاریخ میلادی به شمسی|dt.ToLongPersianDateTimeString()|&#x202b;21 دی 1395، 10:20:02 ق.ظ|
|تبدیل تاریخ میلادی به شمسی|dt.ToPersianDateTimeString("dd MMMM yyyy")|این تبدیل بر اساس فرهنگ اصلاح شده‌ی فارسی صورت می‌گیرد. مانند <br> dt.ToPersianDateTimeString("dd MMMM yyyy - HH:mm") <br> &#x202b; با این خروجی فرضی: «21 دی 1395 - 10:20»|
|تبدیل تاریخ میلادی به شمسی|dt.ToShortPersianDateString()|1395/10/21|
|تبدیل تاریخ میلادی به شمسی|dt.ToShortPersianDateTimeString()|1395/10/21 10:20|
|تاریخ روزهای ابتدا و انتهای سال شمسی|dt.GetPersianYearStartAndEndDates()|[مثال](/src/DNTPersianUtils.Core.Tests/PersianCultureTests.cs)|
|تاریخ روزهای ابتدا و انتهای ماه شمسی|dt.GetPersianMonthStartAndEndDates(5)|[مثال](/src/DNTPersianUtils.Core.Tests/PersianCultureTests.cs)|
|تبدیل عدد انگلیسی به فارسی|123.ToPersianNumbers()|۱۲۳|
|آیا تاریخ و زمان مدنظر آغاز سال نوی شمسی است؟|dt.IsStartOfNewYear()|true/false|
| مناسبت‌های تعطیلات رسمی ایران | Iran.Holidays | مناسبت‌های تعطیلات رسمی ایران از سال 1395 تا پایان سال 1398 |
| دریافت لیست روزهای کاری یک بازه زمانی | IranHolidays.GetBusinessDays() | روزهای کاری ایران از سال 1395 تا پایان سال 1398 |
|تبدیل تاریخ میلادی به قمری|new DateTime(2018, 08, 31).ToIslamicDay()|new IslamicDay(1439, 12, 19)|
|تبدیل تاریخ شمسی به قمری|IslamicDateUtils.PersianDayToIslamicDay(1397, 6, 9)|new IslamicDay(1439, 12, 19)|
-->
اعتبارسنج‌ها
-----------------


|نام متد/امکانات|مثال|خروجی نمونه|
| -------| :------: | :------: |
|تعیین اعتبار تاریخ و زمان رشته‌ای شمسی|"1395/12/30".IsValidPersianDateTime()<br>&#x202b;|true|
| بررسی اعتبار کد ملی | "0010350829".IsValidIranianNationalCode() <br>&#x202b;| true |
| بررسی اعتبار کد بانکی شبا | "IR820540102680020817909002".<br>IsValidIranShebaNumber() <br>&#x202b; | true |
| بررسی اعتبار کد بانکی شتاب | "6221061106498670".<br>IsValidIranShetabNumber() <br>&#x202b;| true |
| بررسی اعتبار شماره موبایل | "09901464762".<br>IsValidIranianMobileNumber() <br>&#x202b;| true |
| بررسی اعتبار شماره تلفن | "37236445".<br>IsValidIranianPhoneNumber() <br>&#x202b; | true |
| بررسی اعتبار کد پستی | "1619735744".<br>IsValidIranianPostalCode() <br>&#x202b; | true |
| بررسی اعتبار اعداد تمام فارسی | "۹۹۹۹۹".<br>ContainsOnlyPersianNumbers() <br>&#x202b; | true |
| بررسی اعتبار حروف و يا اعداد فارسی بودن تنها قسمتی از متن | "Abc تست".<br>ContainsFarsi() <br>&#x202b; | true |
| بررسی اعتبار حروف فارسی بودن تمام متن | "تست".<br>ContainsOnlyFarsiLetters() <br>&#x202b; | true |

<!--

نحوه کار با اطلاعات استان‌ها
-----------------

```csharp
foreach (var province in Iran.Provinces)
{
     foreach (var county in province.Counties)
     {
          foreach (var district in county.Districts)
          {
                foreach (var city in district.Cities)
                {
                }
          }
     }
}
```
-->
