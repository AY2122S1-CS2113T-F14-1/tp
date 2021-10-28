# User Guide

_Ha(ppy)Bit_ is a desktop app aimed to **empower students** to achieve their
**goals**—whether personal, academical, or health—amidst the hectic and stressful
**university life**, through cultivating good **habits**.
The app operates on a [Command Line Interface (CLI)](https://en.wikipedia.org/wiki/Command-line_interface)
while still comprising features typically found in a
[Graphical User Interface (GUI)](https://en.wikipedia.org/wiki/Graphical_user_interface).
Students who type fast will find that _Ha(ppy)Bit_ performs habit tracking more efficiently than your
conventional GUI apps.

You can find out more about _Ha(ppy)Bit_'s Developer Guide or 
its developers (😀 us!) at our [Main Page](README.md).

------------

* [Quick Start](#quick-start)
  * [Start-Up Interface](#start-up-interface)
  * [Main Interface](#main-interface)
* [Using this Guide](#using-this-guide)
  * [Terminology](#terminology)
  * [Icons & Format]()
* [Features](#features)
    * [Ask for Help: `help`](#ask-for-help-help)
    * [Set a Goal: `set`](#set-a-goal-set)
    * [List all Goals: `list`](#list-all-goals-list)
    * [Update a Goal: `update`](#update-a-goal-update)
    * [Remove a Goal: `remove`](#remove-a-goal-remove)
    * [Add a Habit: `add`](#add-a-habit-add)
    * [Change a Habit Name: `change`]()
    * [Complete a Habit: `done`](#complete-a-habit-done)
    * [Delete a Habit: `delete`](#delete-a-habit-delete)
    * [View all Habit: `view`](#view-all-habits-view)
    * [Exit the Program: `bye`](#exit-the-program-bye)
* [About Loading and Saving Data](#about-loading-and-saving-data)
* [FAQ](#faq)
* [Command Summary](#command-summary)
* [Useful Links](#useful-links)

------------

## Quick Start

1. Hype yourself up by dancing. Here begins your journey with _Ha(ppy)Bit_.
2. Ensure you have Java `11` installed in your computer. If you do not have it installed,
   download it [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).
3. Download the latest `tp.jar` [here](https://github.com/AY2122S1-CS2113T-F14-1/tp/releases/tag/v1.0).
4. Copy the file to the folder you want to use as the **home folder** for your _Ha(ppy)Bit_.
5. Open your terminal of choice inside the folder containing `tp.jar` file.
6. Run the file by typing the command `java -jar tp.jar`.
7. Upon loading the app you should see the following screen, indicating that you have successfully run the app.

   ```
   ==============================================================================
    _  _   __   ____  ____  _  _  ____  __  ____
   / )( \ / _\ (  _ \(  _ \( \/ )(  _ \(  )(_  _)
   ) __ (/    \ ) __/ ) __/ )  /  ) _ ( )(   )(
   \_)(_/\_/\_/(__)  (__)  (__/  (____/(__) (__)     tracking habits made fun...
   ==============================================================================

   Howdy! Welcome to Ha(ppy)Bit!
   Select from one of the following menu items:
       [1] About HappyBit
       [2] User Guide
       [3] Developer Guide
       [4] Demo Video
       [5] Start Application
    
   Option:
   ```
   Any keyboard input will appear after `Option: `. Here is where interaction between you and _Ha(ppy)Bit_ takes place.

### Start-Up Interface
In the current loading screen, you will be able to execute the following actions based on your input.

#### Option 1: `About Ha(ppy)Bit`
Learn more about our vision for _Ha(ppy)Bit_ and the team behind it.\

    Option: 1

    Ha(ppy)Bit is a desktop app aimed to improve both the physical and mental lifestyle of students,
    through the setting and tracking of goals to cultivate good habits. The app operates on a Command
    Line Interface (CLI) while still comprising features typically found in a Graphical User Interface
    (GUI). Students who type fast will find that Ha(ppy)Bit performs habit tracking more efficiently
    than your conventional GUI apps.
    
    Meet The Team
    =================================================================
    ||  Tan Kah Heng       ||  Creative Director, Visionary        ||
    ||  Swaminathan Varun  ||  Business Manager, Technical Advisor ||
    ||  Tan Jun Heng Daren ||  Frontend Developer                  ||
    ||  Tan Hui En         ||  Backend Developer                   ||
    ||  Swann Tet Aung     ||  Backend Developer                   ||
    =================================================================
    
    Current Version: v2.0 (updated 28-Oct-2021)
    
    
    Press enter to return to main menu...

#### Option 2: `User Guide`
Learn what you can accomplish with this app.\
This option opens the User Guide in your web browser.

    Option: 2

    Opening in a web browser...
    
    Press enter to return to main menu...

#### Option 3: `Developer Guide`
Learn about the app from the perspective of a software engineer.\
This option opens the Developer Guide in your web browser.

    Option: 3

    Opening in a web browser...
    
    Press enter to return to main menu...

#### Option 4: `Demo Video`
Don't like reading long wordy guides? A video may be just the thing for you!\
This option opens the Demo Video in your web browser.\
(The video is currently unavailable and will be up in v2.1)

    Option: 4

    Opening in a web browser...

    Press enter to return to main menu...

#### Option 5: `Start Application`
If you're a new user, look forward to beginning your _Ha(ppy)Bit_ journey here.\
If you're a returning user, fret not! Everything you gained from your journey has been saved and will be loaded.\
This option starts up the main interface of the application.
    
    Option: 5
    
    Starting application...
    Type 'return' to return to main menu

### Main Interface
Upon formally starting the application, you should see the following screen. 
(See [Start Application](#option-5-start-application) if you are unsure how to get here)
   
    ==============================================================================
     _  _   __   ____  ____  _  _  ____  __  ____
    / )( \ / _\ (  _ \(  _ \( \/ )(  _ \(  )(_  _)
    ) __ (/    \ ) __/ ) __/ )  /  ) _ ( )(   )(
    \_)(_/\_/\_/(__)  (__)  (__/  (____/(__) (__)     tracking habits made fun...
    ==============================================================================
    
    Command:
    
Any keyboard input will appear after `Command: `. Here is where interaction between you and _Ha(ppy)Bit_ takes place.

## Using this Guide
We understand there may be a lot to take in from this user guide. Here are some things to take note
which may make the guide more friendly and helpful.

### Terminology

Name     | Description                                                      | Example
-----    | ---------------------------------------------------------------- | -------------------
Goal     | A long term achievement you wish to accomplish.                  |`Lose 5kg by Dec`
Habit    | Checkpoints; small, actionable tasks to be done to achieve goal. |`Run 5km`
Interval | How often you want to repeat each habit                          |`Run 5km every 7 days` 

Here we distinguish between goals and habits. Although they are commonly used words, the way we
design _Ha(ppy)Bit_ is tightly integral to the way we define them above. We would also like you
to know that the purpose of `habits` is to break down daunting, colossal `goals` into easy, bite-sized
`habits`; tasks that you can complete within a day or as defined by your `interval`.

### Icons & Format
Unfamiliar symbols may confuse. Here is a comprehensive collection of all emojis and syntax we employ.  

> 📃 **Notes**: important information you should take note off (especially if you encounter input errors)

> ⚠ **Warning**: avoid doing the things mentioned here at all costs (unless you're feeling lucky)
 
> 💡 **Pro-Tip!** additional information that may make your tracking journey easier

> 😀 &#8594; Used to show developers' exuberance!!!

> 👍 &#8594; Used to show developers' love and support for you.

>  📃 **Notes about command format:**
> * words enclosed in angle brackets, `<>` are the parameters which is the input the user is supposed to provide.
> * e.g `view g/<goal index>` can be `view g/1`.
> * The parameters enclosed in curly brackets, `{}`, are optional.

## Features

Below are the commands supported by the application.
Each section describes the function of each command and its format.

**Command Format**
* Command may require one or more flags. You may choose to use the flags in any other but ensure that all flags for that
  command is present.\
  (e.g. `add` requires both the `n/`, `g/` and `i/` flag, and possible variations include `add n/habit 1 g/1 i/1` and 
  `add i/1 n/habit 1 g/1`)
* Parameters enclosed in angle brackets `<>` are meant to be replaced.\
  (e.g. `view g/<goal_index>` could be `view g/1`)
* Parameters enclosed within curly brackets, `{}` are optional, although each command must have at least 1 parameter.

### Ask for Help: `help`
Ummm, I'm not sure what the commands are. Fortunately this command is here for you.\
This command displays a list of all possible commands.
If an invalid command is typed, this method will be invoked by default.

Format: `help`

Output:
```
Here are the list of commands:
-------------------------------------------------------------------------------------------------
| Description                | Format                                                           | 
-------------------------------------------------------------------------------------------------
| open command list          | help                                                             | 
-------------------------------------------------------------------------------------------------
| set a goal                 | set n/<goal_name> { t/<goal_type> s/<start_date> } e/<end_date>  | 
-------------------------------------------------------------------------------------------------
| add a habit                | add g/<goal_index> n/<habit_name> i/<interval>                   | 
-------------------------------------------------------------------------------------------------
| update a goal              | update { n/<goal_name> t/<goal_type> e/<end_date> }              | 
-------------------------------------------------------------------------------------------------
| change a habit             | change { g/<goal_index> n/<habit_name> i/<interval> }            | 
-------------------------------------------------------------------------------------------------
| list all goals             | list                                                             | 
-------------------------------------------------------------------------------------------------
| view all habits of a goal  | view g/<goal_index>                                              | 
-------------------------------------------------------------------------------------------------
| remove a goal              | remove g/<goal_index>                                            | 
-------------------------------------------------------------------------------------------------
| delete a habit             | delete g/<goal_index> h/<habit_index>                            | 
-------------------------------------------------------------------------------------------------
| mark a habit as done       | done g/<goal_index> h/<habit_index>                              | 
-------------------------------------------------------------------------------------------------
| return to start screen     | return                                                           | 
-------------------------------------------------------------------------------------------------
| exit the application       | exit                                                             | 
-------------------------------------------------------------------------------------------------
* Replace <> with relevant terms (Exp: <goal_name> --> goal 1)
* Items enclosed within { } are optional
* Use 'list' and 'view' to check the goal and habit indexes respectively

Press enter to return to command mode...
```

### Set a Goal: `set`
Sets a new goal for a long term achievement you wish to accomplish. Goals must have an end date while the goal type and
start dates are optional (well, we wouldn't you to be procrastinating on your goals right?)

Format: `set n/<GOAL_NAME> { t/<GOAL_TYPE> s/<START_DATE> } e/<END_DATE>`

* Goal name can be any name of your choosing (make it meaningful otherwise you won't know what you're tracking).
* Dates must be in `DDMMYYYY` format. For example, 01 January 2021 must be written as `01012020`.
* Goal type is an optional parameter and can take one of the following arguments
  * `sl` &#8594; Sleep
  * `fd` &#8594; Food
  * `ex` &#8594; Exercise
  * `sd` &#8594; Study
  * `df` &#8594; Default (This will be the goal type if the parameter is omitted)
* Start date is an optional parameter. Omitting it will set the start date as today.

> 📃 If more than 8 numbers are used for the date, only the 1st 8 numbers will be treated as the date.

Example:
```
Command: set n/Reduce Spending t/df s/29102021 e/31122021
```

Output:
```
________________________________________________________________________________________________________________________
Your goal: [DF] Reduce Spending has been added.
________________________________________________________________________________________________________________________

Press enter to return to command mode...
```

### List all Goals: `list`
Lists all goals currently set by the user. Here you can see the attributes a goal can have.

Format: `list`

Output:
```
There are 3 goals currently being tracked:
-----------------------------------------------------------------------------
|Index|Name      |Type      |Start Date     |End Date       |Habit Count    |
-----------------------------------------------------------------------------
|1    |example   |Default   |24-Oct-2021    |01-Jan-2022    |0              |
-----------------------------------------------------------------------------
|2    |test 1    |Default   |24-Oct-2021    |30-Oct-2021    |0              |
-----------------------------------------------------------------------------
|3    |test 2    |Default   |24-Oct-2021    |27-Oct-2021    |0              |
-----------------------------------------------------------------------------
```

> 📃 **Note**: <br>
> Each goal has a corresponding <GOAL_INDEX> depending on its location in the list.
> They may change when the goals are deleted (more on how later.) Remembering the index of a goal
> can help in executing commands faster without having to refer to the list every time. 

### Update a Goal: `Update`
Updates an attribute (Name, Date, or Goal Type) of a goal specified by its index. <br>
(To err is human. That's why we have the `update` feature; designed to be more forgiving,
when we have the occasional oopsies. 👍 )

> 📃 **Note:**
> 1. `<GOAL_INDEX>` used in the following commands is an integer.

#### Updating Name

Format: `update g/<GOAL_INDEX> n/<NEW_GOAL_NAME>`

Example:

```
Command: update g/3 n/Reach for the Stars
```
Output:
```
________________________________________________________________________________________________________________________
Your goal "Reach for the Moon" has been changed to "Reach for the Stars".
________________________________________________________________________________________________________________________

Press enter to return to command mode...
```

> 📃 **Note:** <br>
> The update features below are still underway.

#### Updating Start/End Date
Format: `update g/<GOAL_INDEX> s/<NEW_START_DATE>` <br>
_or_ <br>
Format: `update g/<GOAL_INDEX> e/<NEW_END_DATE>`

Example:

```

```
Output:
```

```

#### Updating Goal Type
Format: `update g/<GOAL_INDEX> t/<NEW_GOAL_TYPE>`

Example:

```

```
Output:
```

```

#### Updating Goal Interval
Format: `update g/<GOAL_INDEX> i/<INTERVALS>`

Example:

```

```
Output:
```

```

### Remove a Goal: `remove`
Removes a goal specified by its index. <br>
(Life gets us sometimes. Things don't go as planned. But this isn't calling it quits. It's admitting
defeat today, but to return stronger to fight another time. We got ya fam.)

Format: `remove g/<GOAL_INDEX>`

> 📃 **Note:**
> 1. `<GOAL_INDEX>` is an integer.

Example:
```
Command: remove g/1
```

Output:
```
________________________________________________________________________________________________________________________
Your goal: [DF] Decrease Spending has been removed.
________________________________________________________________________________________________________________________

Press enter to return to command mode...
```

### Add a Habit: `add`
Adds a habit that is linked to a goal. <br>
(Habits are meant to easy and doable. Completing them over time, with consistent dedication, 
one of these habits will be the metaphorical straw that breaks the camel's back. Your goals reached,
without even pulling a muscle.)

Format: `add  n/<HABIT_NAME> g/<GOAL_INDEX> i/<INTERVALS>`

> 📃 **Note:**
> 1. `<GOAL_INDEX>` is an integer.
> 2. `<INTERVALS>` is an integer indicating the number of days between each recurring instance of a habit.

Example:
```
Command: add n/Don't drink BBT g/1 i/3 
```

Output:
```
________________________________________________________________________________________________________________________
Your habit: Don't drink BBT has been added to your goal: [DF] Reduce Spending
________________________________________________________________________________________________________________________

Press enter to return to command mode...
```

### Change a Habit Name: `change`
Changes and updates the name of a habit.

Format: `change g/<GOAL_INDEX> h/<HABIT_INDEX> n/<NEW_HABIT_NAME>`

Example:
```

```

Output:
```

```

### Complete a Habit: `done`
Marks a habit under a goal as done.

Format: `done g/<GOAL_INDEX> h/<HABIT_INDEX>`

> 📃 **Note:**
> 1. `<GOAL_INDEX>` is an integer.
> 2. `<HABIT_INDEX>` is an integer.

Example:
```
done g/1 h/1
```

Output:
```
________________________________________________________________________________________________________________________
Your habit of "Don't drink BBT" under the goal "[DF] Reduce Spending" has been set as done.
________________________________________________________________________________________________________________________

Press enter to return to command mode...
```


### Delete a Habit: `delete`
Deletes a habit under a goal.

Format: `delete g/<GOAL_INDEX> h/<HABIT_INDEX>`

> 📃 **Note:**
> 1. `<GOAL_INDEX>` is an integer.
> 2. `<HABIT_INDEX>` is an integer.

Example:
```
delete g/1 h/1
```

Output:
```
________________________________________________________________________________________________________________________
Your habit of "Don't drink BBT" under the goal "[DF] Reduce Spending" has been deleted.
________________________________________________________________________________________________________________________

Press enter to return to command mode...
```

### View all Habits: `view`
Lists all habits under a specific goal.

Format: `view g/<GOAL_INDEX>`

> 📃 **Note:**
> 1. `<GOAL_INDEX>` is an integer.

Example:
```
view g/1
```

Output
```
________________________________________________________________________________________________________________________
Here are your 1 habit(s) under the goal "[DF] Reduce Spending".
1. [ ] Don't drink BBT (every 3 days)
Last: 25/10/2021, Next: 28/10/2021
________________________________________________________________________________________________________________________
```

### Exit the Program: `bye`
Exits the program. <br>
(Don't stay on _Ha(ppy)Bit_ too long. You have a life out there, go live it!)

> ⚠ **Warning:** <br>
> Make sure to use this command before exiting the program
to ensure that your data are saved properly.

Format: `bye`

Output:
```
Thanks for using Ha(ppy)Bit, see you in a bit! (hehe)

"We are what we repeatedly do. Excellence, then, is not an act, but a habit."
 — Will Durant
```

## About Loading and Saving Data
**Loading saved data:**

Whenever you run the program, the program will **automatically** look for any
saved data in the relative storage path, `data/habits.txt`.
* If the storage file is found, `File exists` will be printed.
* If the storage file is not found, the program will create
  one for you at the relative storage path, `data/habits.txt`.

**Saving data:**

* Everytime you make changes to any of your goals and habits, the changes
  are **immediately** reflected in the storage file. This is to ensure that in the
  event you closed the program without using the command `bye`, we can ensure that
  **most of your data are saved**.
* Before you exit the program, the goals you set and the habits you have added
  are **automatically** saved in a text file at the relative storage path, `data/habits.txt`.

## FAQ

**Q**: How do I transfer my data to another computer?
<br>
**A**: You can just copy-paste the habits.txt in the path `data/habits.txt` file from one computer to another and all
your data will be there!

> 💡 **Pro Tip!** Have your home folder reside in a cloud storage service (OneDrive, iCloud, etc.) to sync your data
> between devices.

**Q**: Are there any books you recommend?
<br>
**A**: Data Structures and Algorithms in Java &#8594; [here](https://www.amazon.com/Data-Structures-Algorithms-Java-2nd/dp/0672324539)

## Command Summary

Action | Command Format | Example
------------ | ------------ | ------------
Set goal | `set n/<GOAL_NAME> { t/<GOAL_TYPE> s/<START_DATE> } e/<END_DATE>` | `set n/Reduce spending e/31122022`
List goals | `list` | `list`
Update goal | `update g/<GOAL_INDEX> n/<NEW_GOAL_NAME>` | `update g/1 n/Decrease Spending`
Remove goal | `remove g/<GOAL_INDEX>` | `remove g/1`
Add habit | `add n/<HABIT_NAME> g/<GOAL_INDEX> i/<INTERVAL>` | `add n/Don't drink BBT g/1 i/3`
Done habit | `done g/<GOAL_INDEX> h/<HABIT_INDEX>` | `done g/1 h/1`
Delete habit  | `delete <GOAL_INDEX> <HABIT_INDEX>` | `delete g/1 g/1`
View habits | `view g/<GOAL_INDEX>` | `view g/1`
Exit Program | `bye` | `bye`

## Useful Links

Visit our [Main Page](README.md) to find more useful links.

Watch our wacky Demo Video v0 [here](https://www.youtube.com/watch?v=dQw4w9WgXcQ)!
