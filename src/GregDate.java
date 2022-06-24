import java.util.Date;

public class GregDate{
    long a, b, c, d, e, f;
    double Hours, x;
    int Day,Month,Year,Hour,Min;
    double Sec;
    Date DOY;
    private Date day2doy(int year, int month, int day){
             return null;
    };

public GregDate(double mjd) {
    long a, b, c, d, e, f;
    double Hours, x;

    // Convert Julian day number to calendar date
    a = (long) (mjd + 2400001.0);

    if (a < 2299161) {  // Julian calendar
        b = 0;
        c = a + 1524;
    } else {                // Gregorian calendar
        b = (long) ((a - 1867216.25) / 36524.25);
        c = a + b - (b / 4) + 1525;
    }

    d = (long) ((c - 122.1) / 365.25);
    e = 365 * d + d / 4;
    f = (long) ((c - e) / 30.6001);

    long temp = (long) (30.6001 * f);
    this.Day = (int) (c - e - temp);
    temp = (long) (f / 14);
    this.Month = (int) (f - 1 - 12 * temp);
    temp = (long) ((7 + Month) / 10);
    this.Year = (int) (d - 4715 - temp);

    Hours = 24.0 * (mjd - Math.floor(mjd));

    this.Hour = (int) Hours;
    x = (Hours - Hour) * 60.0;
    this.Min = (int) x;
    this.Sec = (x - Min) * 60.0;
    this.DOY = day2doy(this.Year, this.Month, this.Day);
}


}