# Sarcio

Sarcio includes a plethora of memory leak fixes, memory usage optimizations, bugfixes, and general tweaks,
driven by real profiling data and user need.

## What it does

- **Memory leak fixes**: memory gets released properly instead of piling up over a long session
- **Lower memory usage**: less RAM used by worlds, chunks, textures, and networking
- **Fewer allocations**: less garbage created each frame, so fewer lag spikes from garbage collection
- **Bugfixes**: fixes for long-standing vanilla bugs in rendering, entities, sounds, GUIs, and more
- **Tweaks**: faster server list pinging, and the option to hide the Realms button

## Requirements

- Minecraft 1.8.9
- [Ornithe](https://ornithemc.net/) (Fabric Loader 0.19.0+)

## Config

Options are in `config/sarcio.json`. With [Argentum](https://github.com/QuicksilverMC/Argentum), options are in the video settings menu.
