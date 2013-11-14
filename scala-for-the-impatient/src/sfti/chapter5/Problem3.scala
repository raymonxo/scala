package sfti.chapter5

//-----------------------------------------------------------------------------
// Write a class Time with read-only properties hours and minutes and a method
// before(other: Time): Boolean that checks whether this time comes before the
// other. A Time object should be constructed as new Time(hrs, min), where hrs
// is in military time format (between 0 and 23).
//-----------------------------------------------------------------------------
object Problem3 {
  object Time {
    val HoursPerDay = 24
    val MinutesPerHour = 60
  }
    
  class Time(private val hours: Int, private val minutes: Int) {
    require(hours >= 0)
    require(hours < Time.HoursPerDay)
    require(minutes >= 0)
    require(minutes < Time.MinutesPerHour)
    
    def before(other: Time): Boolean = {
      hours < other.hours ||
        (hours == other.hours && minutes < other.minutes) 
    }
  }
  
  def apply() {
    assert(new Time(5, 50) before new Time(23, 35))
    assert(new Time(5, 50) before new Time(5, 51))
    assert(!(new Time(5, 50) before new Time(3, 59)))
    assert(!(new Time(5, 50) before new Time(5, 49)))
    assert(!(new Time(5, 50) before new Time(5, 50)))
  }
}