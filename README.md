# Image Viewer

This project aims at creating a simple Image Viewer which can start a question dialog to choose a Image Viewer Activity. Besides, when you are trying to open a local image file, the dialog will also show up to provide selections for you.

This project contains two activities:

- MainActivity
- ViewImageActivity

## Activity Introduction

### MainActivity

The basic initial activity of this app. It only provides a button widget on its UI. When you click down the button, a system question dialog will ask you to select an implicit activity to start.

The MainActivity saves the project's img resource file to a local path firstly which is specified by two static vars in ViewImageActivity.

### ViewImageActivity

A custom activity gives users another choice to view images.