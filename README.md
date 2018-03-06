# wicketdoubleclickexample
Example for how to solve doubleclick issue in Wicket

This example contains a cross-browser solution for preventing double click (thus also double submit) for ajax- and non-ajax buttons and links.
Contains a sample implementation in HomePage with a timout to simulate a long-term event handling.
For buttons the disabling after the first click is done using css pointer-events. For links there's a js-file containing a method which creates a temporary copy of the orininal link. This is done, because there is no way to disable a link working in all browsers.
