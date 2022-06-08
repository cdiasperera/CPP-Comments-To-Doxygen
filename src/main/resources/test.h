#pragma once

#include <unordered_map>

#include "AABBTreeNode.h"
#include "AABBTreeInsertor.h"
#include "AABBTreeCollisionDetector.h"

#include "AABBHeuristic.h"

namespace ocxcollisions {
  /**
   * \brief  An AABBTree. This is a binary tree structure that is auto-balancing
   * and each node represents some AABB. The key invariant is that each node's
   * children must have an AABB that is completely contained by the parent AABB.
   *
   * This tree allows fast checking of whether AABBs inserted collide with an
   * AABB to check against.
   *
   * This class does not store the object that the AABB inserted is associated with,
   * but it does associate an ID associated with that AABB.
   *
   * This class is templated against K, the id to be attached to the AABB inserted into the tree.
   * K should be able to inserted into an std::unsorted_set.
   */
  template <typename K>
  class AABBTree {
    std::shared_ptr<AABBTreeNode> root_;
    AABBHeuristic heuristic_;

    /**
     * \brief The number of nodes the user has inserted. This is not the size of the tree
     * since we create internal nodes and nodes may be removed.
     */
    unsigned int numInserted_;

    /**
     * \brief A mapping of the ids in the AABB tree to the IDs given by the user.
     */
    std::unordered_map<int, K> idMap_;
    /**
     * \param rootOfSubTree The root of the subtree to get the number of leaves of
     * \return The number of leaves rooted at the provided root
     */
    static int getNumLeavesAtSubtree(std::shared_ptr<AABBTreeNode> rootOfSubTree);

  public:
    AABBTree();
    explicit AABBTree(AABBHeuristic heuristic);
    /**
     * \brief Inserts the aabb in this tree, with a given Key id
     * \param box The aabb you want to insert in the tree
     * \param id The id assigned to the aabb box
     */
    void insert(const AABB& box, K id);
    /**
     * \return Returns a set of the collisions between the leaves and the aabb toCheckAgainst
     */
    std::vector<K> getCollisions(const AABB& toCheckAgainst);
    /**
     * \return Returns the depth of this tree
     */
    [[nodiscard]] int getDepth() const;
    /**
     * \return The number of leaves in the tree
     */
    [[nodiscard]] int getNumLeaves() const;
  };

  template <typename K>
  int AABBTree<K>::getNumLeavesAtSubtree(std::shared_ptr<AABBTreeNode> rootOfSubTree) {
    if (rootOfSubTree->isLeaf()) {
      return 1;
    }

    return getNumLeavesAtSubtree(rootOfSubTree->getLeft()->lock())
      + getNumLeavesAtSubtree(rootOfSubTree->getRight()->lock());
  }

  template <typename K>
  AABBTree<K>::AABBTree() : heuristic_{ AABBHeuristic() }, numInserted_{ 0 } {}

  template <typename K>
  AABBTree<K>::AABBTree(AABBHeuristic heuristic) : heuristic_{ heuristic }, numInserted_{ 0 } {}

  template <typename K>
  void AABBTree<K>::insert(const AABB& box, K id) {
    /**
     * numInserted_ will always be unique since we never decrement it.Hence we can use it
     * as an id for our AABB tree. However, since internal nodes are indicated by 0, we will
     * use numInserted_ + 1
     */
    idMap_.insert({ numInserted_ + 1, id });
    root_ = AABBTreeInsertor::insert(numInserted_ + 1, box, root_, heuristic_);

    ++numInserted_;
  }

  template <typename K>
  std::vector<K> AABBTree<K>::getCollisions(const AABB& toCheckAgainst) {
    const auto collisions = AABBTreeCollisionDetector::getCollisions(toCheckAgainst, root_);

    std::vector<K> collisionsWithUserProvidedIDs = std::vector<K>();

    for (const auto& elem : collisions) {
      collisionsWithUserProvidedIDs.push_back(idMap_.at(elem));
    }

    return collisionsWithUserProvidedIDs;
  }

  template <typename K>
  int AABBTree<K>::getDepth() const {
    return root_->getHeight();
  }

  template <typename K>
  int AABBTree<K>::getNumLeaves() const {
    return getNumLeavesAtSubtree(root_);
  }

}
