We are already in the middle of the run-up to Christmas, and at this time the penguins of the PGdP are also preparing for Christmas. We therefore call such a penguin Adventuin.

Adventuin
An Adventuin has a name (a string), a height in centimeters (integer number), a color (for this there is a class RgbColor already created in the project), a (Christmas) hat and the language that it usually uses to speak. For hat and language we still need separate classes, we will use enums for them:

 Implement enum HatType 1 of 1 tests passing
Create an Enum HatType with the values SANTA_CLAUS, REINDEER, FISHY_HAT and NO_HAT;

 Implement enum Language 1 of 1 tests passing
Create an Enum Language with the values ENGLISH and GERMAN. The class should have a method getLocalizedChristmasGreeting (String greeterName), which can be called on a Language value and returns a Christmas greeting in the respective language (as a string):

For GERMAN: Fröhliche Weihnachten wünscht dir and after a space the greeterName with a ! at the very end.
For ENGLISH: greeterName immediately followed by a space and wishes you a Merry Christmas!
If you can speak more languages, you are welcome to add them (this is optional and will not be tested).
 Adventuin is present with all of its methods 2 of 2 tests passing
Then we can create the class Adventuin which contains the attributes mentioned. Make the public getters getName, getHeight, getColor, getHatType and getLanguage available for this. You also need a public constructor that accepts the name, size, color, hat type and language in exactly this order. For your own testing it is advisable to overwrite toString (). A validity check (e.g. for zero) is not tested, but can be added.

The test_Adventuin_createExample test does the following:
new Adventuin ("AdvenTux", 123, new RgbColor (3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH);

The Party
Now that the basics are done, we want to invite the Adventuins to a party and perform some interesting operations on them. All methods of this subtask are created in the class AdventuinParty and should be static. Furthermore, every method receives a java.util.List with Adventuins as parameters, which contains all participating adventuins. This list is always free of duplicates and free of null. They also don't return null in the methods, either directly or in any collections/maps.

 Group participants by hats 1 of 1 tests passing
Implement the groupByHatType method. Return a Map<HatType, List <Adventuin>> in which the submitted participants are grouped by hats. The map should only contain the hat types that at least one participant has. (This is also the case with the Maps in the following subtasks)

 Christmas greetings 1 of 1 tests passing
Implement the method printLocalizedChristmasGreetings. Nothing should be returned, but for all Adventuins in the list their personal Christmas greetings should be displayed on a line in the console. The string that the respective language object returns using getLocalizedChristmasGreeting with the name of the Adventuin as an argument should be used. The order should be determined by the height of the Adventuins, the smallest is allowed to say hello first, so sort the adventuins in ascending order according to their height.
You can use System.out.println(String) to print text in the console.
Example:

Christian wishes you a Merry Christmas!
 Adventuins with the longest names in their hat grouping 1 of 1 tests passing
Implement the method getAdventuinsWithLongestNamesByHatType. Return a map <HatType, List<Adventuin>> in which those participants are grouped by hats whose name length is equal to the maximum name length (number of characters) in the group of adventuins with the same hat type. Since several Adventuins can have names of the same length, that too has to be a List.

 Average color brightness by size 1 of 1 tests passing
Implement the method getAverageColorBrightnessByHeight. Return a Map<Integer, Double> that contains the average brightness of the Adventuins' colors. Grouping is done by size rounded in steps of 10 cm, that means for example from 95 to 104 all are grouped under integer 100, and 105 to 114 under 110, and so on. For the average brightness, the colors must be transformed to their brightness, for this we first convert them to 8-bit colors (value range 0 to 255) using the method toRgbColor8Bit and then we can use the formula (0.2126∗R+0.7152∗G+0.0722∗B)/255(0. 2126∗R+0.7152∗G+0.0722∗B)/255(0.2126∗R+0.7152∗G+0.0722∗B)/255. R, G and B are red, green and blue, the class RgbColor has suitable getters.

(To experts: we just assume RgbColor is linear RGB and prefer to keep it simple).

 Adventuin circle dance 1 of 1 tests passing
At the end of the party, our adventuins would like to perform a dance on an advent wreath in a large circle. It is particularly important to them that the size difference to the neighbors is as large as possible among adventuins with the same hat. To be able to measure that, the adventuins now want to calculate the absolute difference between the difference averages "greater than predecessor" and "smaller than predecessor" and thus obtain a measurement variable for the mixing of the variables in the dance circle.However, the Adventuins want to keep the freedom to dance next to each other in groups of the same size within the hat groups without worsening the statistics. Implement the getDiffOfAvgHeightDiffsToPredecessorByHatType method. Return a Map<HatType, Double> that:

Grouped by HatType and then within each group …

Adventuin size differences to the respective predecessor (difference between successor and predecessor)

… grouped according to the sign of the difference result (sign: -1, 0 or 1)

… with the value being absolute difference between

… the average of all negative height differences (or 0.0 if not available) and

… the average of all positive height differences (or 0.0 if not available).

calculated. It should be noted that the adventuins actually stand in a circle, and the predecessor (with the same hat type, of course) of the first adventuin of a hat type group is the last adventuin in this group. If a penguin is alone with his hat type, he is his own predecessor, but this is not a problem for the calculation (this then falls into the difference category 0), and the absolute difference of the difference averages is therefore also 0 in its group.

For example, if we have two Adventuins with hat type SANTA_CLAUS, which have sizes 100 and 120, the first difference is 100-120 = -20, and the second difference 120-100 = 20; the absolute difference between them is 40.
If we have three Adventuins with hat type SANTA_CLAUS, which have the sizes 100 and 120 and 100, the first difference is 100-100 = 0, the second difference 120-100 = 20 and the third difference 100-120 = -20; the absolute difference between them is still 40. Here the case that two penguins of exactly the same size follow each other in the hat group, the statistics should not deteriorate.
But if we have four Adventuins with hat type SANTA_CLAUS, which have the sizes 100 and 120, 100 and 110, the first difference is 100-110 = -10, the second difference 120-100 = 20, the third difference 100-120 = - 20 and the fourth difference is 110-100 = 10. The averages are -15 for the negative and 15 for the positive differences, so the absolute difference is only 30.
