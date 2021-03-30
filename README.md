# Getting Started

The whole application behaves like a "normal" Spring boot application, so feel free to run it like one.

For kubernetes however, you need a running cluster and a docker registry. I recommend here to use microk8s, which comes with a built-in registry, the jib configuration uses said registry. If you don't use it, you'll have to reconfigure the docker image.


