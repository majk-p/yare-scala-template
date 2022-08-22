# Yare.io Scala template

A easy to setup template for creating Yare.io strategies with Scala

## Setup

Dependencies:
 - node.js v16 (https://nodejs.org/en/)
 - sbt

## Usage

 - Fork this repository
 - Repackage it to avoid using my domain name (`net.michalp`)
 - Implement your own strategy in `Strategy.run`
 - When done, launch `sbt` console and run `buildStrategy` task
 - The JS bundle is waiting for you in `./target/yare-bundle` - copy the contents of the file and paste it on yare.io
 
