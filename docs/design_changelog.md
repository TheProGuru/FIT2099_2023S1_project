Changes made to design during Assignment 2
- Generalized HealAction to ConsumeAction to better enable extensibility
- Added a Consumable interface to enable to allow ConsumableAction to deduct uses from the item.
- 
- Made Archetype abstract class per suggestion and moved all the archetypes to it
- Player now receives archetype as an input to its constructor

- The rune wallet idea was scrapped per Feedback and replaced with a rune manager, Rune manager is a singleton class that acts as the intermediary for all rune related things this includes:
  - Addition of runes
  - Subtraction of runes
  - Holding the balance 
  - droping and picking up rune piles using the PickUpRuneAction and DropRuneAction

- instead of having a reset type enum that manages resets and rests all of it is now done through resetmanager:
  - the ResetManager now has two main methods, runRest() and runReset()
  - the runReset() resets all objects in the game
  - the runRest() however checks if the object resetOnRest() returns true before reseting
  - resetOnRest() is in the resettable interface and objects that are not supposed to reset on rest need to overide this method
  
