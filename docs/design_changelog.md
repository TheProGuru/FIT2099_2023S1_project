Changes made to design during Assignment 2
- Generalized HealAction to ConsumeAction to better enable extensibility
- Added a Consumable interface to enable to allow ConsumableAction to deduct uses from the item.
- Made Archetype abstract class per suggestion and moved all the archetypes to it
- Player now receives archetype as an input to its constructor
