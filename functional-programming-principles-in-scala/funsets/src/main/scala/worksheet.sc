import funsets.FunSets._

val s1 = singletonSet(1)
val s2 = singletonSet(2)
val s3 = union(s1, s2)

contains(s3, 1)
contains(s3, 2)
contains(s3, 3)

