package sfti.chapter5

//-----------------------------------------------------------------------------
// Reimplement the Time class from the preceding exercise so that the internal
// representation is the number of minutes since midnight (between
// 0 and 24 × 60 – 1). Do not change the public interface. That is, client code
// should be unaffected by your change.
//-----------------------------------------------------------------------------
object Problem4 {
  object Time {
    val HoursPerDay = 24
    val MinutesPerHour = 60
  }
  
  class Time(hours: Int, minutes: Int) {
    require(hours >= 0)
    require(hours < Time.HoursPerDay)
    require(minutes >= 0)
    require(minutes < Time.MinutesPerHour)

    private val minutesSinceMidnight = hours * 60 + minutes
    
    def before(other: Time): Boolean = {
      minutesSinceMidnight < other.minutesSinceMidnight 
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