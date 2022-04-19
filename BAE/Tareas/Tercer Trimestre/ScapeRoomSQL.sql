/*
http://mystery.knightlab.com/
*/
SELECT * FROM crime_scene_report
WHERE type='murder' AND city='SQL City' AND date='20180215';
/*    20180215 | murder	| Someone killed the guard! He took an arrow to the knee! |	SQL City    */

SELECT * FROM interview
WHERE transcript LIKE '%knee%';
/*    63126 | 77054 | 90097 | 81787 : down on one knee. ‘I’m a poor man, your Majesty,’ he began.     */
/*    48864 | 21314 : down on one knee as he spoke, ‘we were trying--’      */