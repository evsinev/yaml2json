package com.payneteasy.yaml2json;

import org.snakeyaml.engine.v2.nodes.Node;

public interface IWarningListener {

    void nodeIsNotScalar(Node aNode);

}
