# Brainstorming Data 

## Designers 
* [Subversive Cross Stitch](subversivecrossstitch.com)
* [Witchy Stitcher](thewitchystitcher.com)
* [Satsuma Street](satsumastreet.com)
* [Tiny Modernist](tinymodernist.com)
* [Fiddlesticks](fiddlesticksau.com)

## Pattern data points 
* Author 
* Size (sm/med/lg/xl?)
* Source (website, etsy, facebook)
* Recommended floss (DMC/Anchor?)
* Price (free)
* Colors used (?!?!?!)
* Keywords / attributes
  * alphabet/font, profanity, sampler 


designer

| id | name | website |
| ----- | ----- | ----- |
| int | varchar(30) | varchar(35) |

pattern 

| id | name | price | source | designer_id | 
| ----- | ----- | ----- | ----- | ----- | 
| int | varchar(30) | varchar(5) | varchar(100) | int | 

```
select pattern.name, pattern.price
from pattern
where designer_id = [currentDesigner]
```

user

| id | username | password | isDesigner | isAdmin |
| ----- | ----- | ----- | ----- | ----- |
| int | varchar(25) | ???? | boolean | boolean |

floss

| id | brand | color | description | 
| ----- | ----- | ----- | ----- |
| int | varchar(10) | varchar(5) | varchar(25) |

patternFloss 

| pattern_id | floss_id | 
| --- | --- | 
| int | int | 

```
select floss.brand, floss.color
from floss
join patternFloss on floss.id = patternFloss.floss_id 
where patternFloss.pattern_id = [currentPatternId]
```