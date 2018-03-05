package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringToTypeNameConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringToTypeNameConverter.class);

    public static TypeName toTypeName(final String value) {
        String sanitizedValue = StringUtils.deleteWhitespace(value);
        LOGGER.debug("sanitized value " + sanitizedValue);
        TreeNode tree = buildTree(sanitizedValue);
        return tree.toTypeName();
    }

    private static TreeNode buildTree(final String value) {
        TreeNode root = new TreeNode();
        TreeNode currentNode = root;
        LOGGER.debug("root " + root);
        for (char c : value.toCharArray()) {
            if (c == '<') {
                LOGGER.debug("hit < " + currentNode.getValue());
                LOGGER.debug("set node " + currentNode + " with value " + currentNode.getValue());
                TreeNode child = new TreeNode();
                LOGGER.debug("adding child " + child + " to " + currentNode);
                currentNode.addChild(child);
                currentNode = child;
                LOGGER.debug("set current node to " + currentNode);
            } else if (c == '>') {
                LOGGER.debug("hit > " + currentNode.getValue());
                LOGGER.debug("set node " + currentNode + " with value " + currentNode.getValue());
                currentNode = currentNode.getParent();
                LOGGER.debug("set current node to " + currentNode);
            } else if (c == ',') {
                TreeNode child = new TreeNode();
                currentNode.getParent().addChild(child);
                currentNode = child;
            } else {
                LOGGER.debug("appending " + c);
                currentNode.append(c);
            }
        }

        root.debug();
        return root;
    }

}
