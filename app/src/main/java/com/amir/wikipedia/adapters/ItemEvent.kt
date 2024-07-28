package com.amir.wikipedia.adapters

import com.amir.wikipedia.dataclasses.ItemPost

interface ItemEvent {
    fun onItemClicked (itemPost: ItemPost)
}